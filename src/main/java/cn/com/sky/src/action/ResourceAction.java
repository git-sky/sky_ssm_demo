package cn.com.sky.src.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import service.interfaces.ResourceService;
import entity.Resource;
import entity.Resourcetype;
import entity.Users;

public class ResourceAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String uploadDir;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// 资源名称
	String name;
	// 资源类型
	String resourcetypeid;

	// 所有资源类型
	List<Resourcetype> alltype;

	public List<Resourcetype> getAlltype() {
		return alltype;
	}

	public void setAlltype(List<Resourcetype> alltype) {
		this.alltype = alltype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourcetypeid() {
		return resourcetypeid;
	}

	public void setResourcetypeid(String resourcetypeid) {
		this.resourcetypeid = resourcetypeid;
	}

	private ResourceService rs;

	// 注入资源信息
	Resource resource = new Resource();

	public void setRs(ResourceService rs) {
		this.rs = rs;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public Resource getModel() {
		return resource;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public String show() {

		int flag = 0;

		if (null != ServletActionContext.getRequest().getParameter("flag")) {

			flag = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("flag"));

		}

		int resourceid = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("resourceid"));

		Resource resource = rs.queryResourceById(resourceid);

		String page = ServletActionContext.getRequest().getParameter("page");
		if (null != page) {
			ServletActionContext.getRequest().setAttribute("page", page);
		}

		ServletActionContext.getRequest().setAttribute("resource", resource);

		if (flag == 2) {
			return "show";
		} else {
			return "show2";
		}
	}

	public String delete() {

		int flag = 0;

		if (null != ServletActionContext.getRequest().getParameter("flag")) {

			flag = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("flag"));

		}
		try {

			// 删除数据库中的记录
			String resourceid = ServletActionContext.getRequest().getParameter(
					"resourceid");
			rs.deleteResource(Integer.parseInt(resourceid));

			// 删除磁盘上的文件
			// String filename = new String(ServletActionContext.getRequest()
			// .getParameter("filename").getBytes("iso8859-1"), "utf-8");
			//
			// String path =
			// ServletActionContext.getServletContext().getRealPath(
			// uploadDir);
			//
			// File file = new File(path + "\\" + filename);
			// file.delete();

			// 删除后 显示结果
			// return showall();
			if (flag == 2) {
				return showuser();
			} else {
				return showall();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;

	}

	public String upload() {
		String username = "";
		int total = 0;
		Users user = null;
		String a = ServletActionContext.getRequest().getParameter("a");

		// 根据条件判断上传资源还是查询资源的类型
		if (a == null) {
			try {
				// 查询资源类型
				alltype = rs.queryAllResourcetype();

				setAlltype(alltype);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		} else {

			// 创建用于存放上传文件的文件夹
			String path = ServletActionContext.getServletContext().getRealPath(
					uploadDir);

			// 不同的用户上传到自己的文件夹中
			if (null != ServletActionContext.getRequest().getSession()
					.getAttribute("user")) {
				username = ((Users) ServletActionContext.getRequest()
						.getSession().getAttribute("user")).getUsername();
			} else if (null != ServletActionContext.getRequest().getSession()
					.getAttribute("admin")) {
				username = ((Users) ServletActionContext.getRequest()
						.getSession().getAttribute("admin")).getUsername();
			}

			File dir = new File(path + "/" + username);
			if (!dir.exists()) {
				dir.mkdir();
			}

			// 上传文件
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;

			try {
				FileInputStream fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);

				FileOutputStream fos = new FileOutputStream(new File(dir,
						fileFileName));

				bos = new BufferedOutputStream(fos);

				byte[] buffer = new byte[4096];

				int len = -1;

				while ((len = bis.read(buffer)) > 0) {
					total = total + len;
					bos.write(buffer, 0, len);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (null != bis) {
					try {
						bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (null != bos) {
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			// 资源的大小,单位换成K
			total=total/1024;
			resource.setSizes(total);

			// 设置资源类型
			String resourcetypeid = ServletActionContext.getRequest()
					.getParameter("resourcetypeid");

			Resourcetype rt = new Resourcetype();

			rt.setResourcetypeid(Integer.parseInt(resourcetypeid));

			resource.setResourcetype(rt);

			// 设置上传的用户

			if (null != ServletActionContext.getRequest().getSession()
					.getAttribute("user")) {
				// 普通用户
				user = (Users) ServletActionContext.getRequest().getSession()
						.getAttribute("user");
			} else if (null != ServletActionContext.getRequest().getSession()
					.getAttribute("admin")) {
				// 管理员
				user = (Users) ServletActionContext.getRequest().getSession()
						.getAttribute("admin");
			}

			Users usr = new Users();

			usr.setUserid(user.getUserid());

			resource.setUsers(usr);

			String date = sdf.format(new Date());
			resource.setDate(date);

			// 为上传的文件重命名以防止文件的覆盖
			Date dt = new Date(System.currentTimeMillis());
			SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String rand = fmt.format(dt);
			File aa = new File(dir + "/" + fileFileName);
			String bb = aa.toString().substring(0,
					aa.toString().lastIndexOf("."));
			String cc = aa.toString().substring(aa.toString().lastIndexOf("."));
			File dd = new File(bb + rand + cc);
			aa.renameTo(dd);

			// 设置资源的修改后的真实名称
			resource.setFilename(username + "/" + dd.getName());

			// 把上传的文件的信息存到数据库中
			rs.addResource(resource);

			return "insert";
		}
	}

	public String update() {
		String resourceid = ServletActionContext.getRequest().getParameter(
				"resourceid");

		String resourcetypeid = ServletActionContext.getRequest().getParameter(
				"resourcetypeid");
		// 取得文章的类型数目
		alltype = rs.queryAllResourcetype();
		setAlltype(alltype);

		// 得到该
		Resource resource = rs.queryResourceById(Integer.parseInt(resourceid));

		Resourcetype resourcetype = rs.queryResourcetypeById(Integer
				.parseInt(resourcetypeid));

		// 得到所修改的数据所在的页码
		String page = ServletActionContext.getRequest().getParameter("page");

		ServletActionContext.getRequest().setAttribute("page", page);

		ServletActionContext.getRequest().setAttribute("resource", resource);

		ServletActionContext.getRequest().setAttribute("resourcetype",
				resourcetype);
		return "update";
	}

	public String updatesubmit() throws Exception {
		System.out.println(resourcetypeid + "全局3");
		int resourcetypeid = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("resourcetypeid2"));

		int userid = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("userid"));

		Resourcetype resourcetype = new Resourcetype();
		resourcetype.setResourcetypeid(resourcetypeid);

		Users user = new Users();
		user.setUserid(userid);

		resource.setUsers(user);
		resource.setResourcetype(resourcetype);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String date = sdf.format(new Date());
		resource.setDate(date);

		rs.updateResource(resource);
		System.out.println(resourcetypeid + "全局4");
		return showall();

	}

	public String showsome() {
		String hql = "from Resource order by date desc";
		List<Resource> some = rs.queryAllResource(hql, 1, 5);
		ServletActionContext.getRequest().setAttribute("resource", some);
		return "some";
	}

	public String showuser() {

		int userid = 0;

		if (null != ServletActionContext.getRequest().getParameter("userid")) {
			userid = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("userid"));

		} else {
			Object obj = ServletActionContext.getRequest().getSession()
					.getAttribute("user");

			Users u = (Users) obj;
			userid = u.getUserid();
		}

		ServletActionContext.getRequest().setAttribute("userid", userid);

		String hql = "from Resource resource where resource.users.userid='"
				+ userid + "'";

		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

		totalCount = rs.getTotalCount(hql);

		totalPage = ((totalCount + pageSize) - 1) / pageSize;
		if (totalPage == 0) {
			totalPage = 1;
		}

		if (pageString == null || pageString.length() == 0) {
			curPage = 1;
		} else if (null != pageString && pageString.length() != 0) {
			try {
				curPage = Integer.parseInt(pageString);
				if (curPage > totalPage)
					curPage = totalPage;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		List<Resource> resource = rs.queryAllResource(hql, curPage, pageSize);
		// resource = Convert(resource);
		ServletActionContext.getRequest().setAttribute("resource", resource);
		return "showuser";
	}

	public String showall() {
		alltype = rs.queryAllResourcetype();
		setAlltype(alltype);

		// 资源名称
		String title = ServletActionContext.getRequest().getParameter(
				"resourcetitle");

		if (null != title) {
			ServletActionContext.getRequest().getSession().setAttribute(
					"title", title);
		}

		// 资源类型
		String resourcetypeid = ServletActionContext.getRequest().getParameter(
				"resourcetypeid");

		if (null != resourcetypeid) {
			Resourcetype resourcetype = rs.queryResourcetypeById(Integer
					.parseInt(resourcetypeid));

			ServletActionContext.getRequest().getSession().setAttribute(
					"resourcetype", resourcetype);
		}

		// 条件查询
		String condition = ServletActionContext.getRequest().getParameter(
				"condition");

		if (condition != null) {
			// 条件查询
			if (null != title && null != resourcetypeid) {

				if (null == title) {
					ServletActionContext.getRequest().getSession()
							.setAttribute("title", "");
				}

				// 查询所有的数据
				if (Integer.parseInt(resourcetypeid) == 0) {
					ServletActionContext.getRequest().getSession()
							.setAttribute(
									"condition",
									"from Resource resource where resource.resourcename like '%"
											+ title + "%' order by date desc");
				} else {
					// 按条件查询
					ServletActionContext
							.getRequest()
							.getSession()
							.setAttribute(
									"condition",
									"from Resource resource where resource.resourcename like '%"
											+ title
											+ "%' and resource.resourcetype.resourcetypeid = '"
											+ resourcetypeid
											+ "' order by date desc");

				}

			} else {

				ServletActionContext.getRequest().getSession().removeAttribute(
						"condition");
				ServletActionContext.getRequest().getSession().removeAttribute(
						"title");
				ServletActionContext.getRequest().getSession().removeAttribute(
						"resourcetype");

				// 直接从manage.jsp查询
				ServletActionContext.getRequest().getSession().setAttribute(
						"condition", "from Resource order by date desc");
				ServletActionContext.getRequest().getSession().setAttribute(
						"title", "");
			}
		}

		String hql = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("condition");

		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

		totalCount = rs.getTotalCount(hql);

		totalPage = ((totalCount + pageSize) - 1) / pageSize;
		if (totalPage == 0) {
			totalPage = 1;
		}

		if (pageString == null || pageString.length() == 0) {
			curPage = 1;
		} else if (null != pageString && pageString.length() != 0) {
			try {
				curPage = Integer.parseInt(pageString);
				if (curPage > totalPage)
					curPage = totalPage;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		List<Resource> all = rs.queryAllResource(hql, curPage, pageSize);
		// all = Convert(all);

		// 放入查询出的article
		ServletActionContext.getRequest().setAttribute("all", all);

		return "showall";

	}

	public String showmy() {

		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		int id = user.getUserid();

		String name = ServletActionContext.getRequest().getParameter(
				"resourcetitle");

		if (null != name && name.isEmpty() == false) {

			Resource resource = rs.queryResourceByName(name);

			String hql = "from Resource res where res.userid='" + id
					+ "' and res.resourcename='" + name + "'";

			totalCount = rs.getTotalCount(hql);

			totalPage = ((totalCount + pageSize) - 1) / pageSize;

			if (totalPage == 0) {
				totalPage = 1;
			}

			curPage = 1;

			ServletActionContext.getRequest().setAttribute("all", resource);
			return "showall";
		} else {

			String hql = "from Resource res where res.users.userid='" + id
					+ "'";

			totalCount = rs.getTotalCount(hql);

			totalPage = ((totalCount + pageSize) - 1) / pageSize;

			if (totalPage == 0) {
				totalPage = 1;
			}
			String pageString = ServletActionContext.getRequest().getParameter(
					"page");

			if (pageString == null || pageString.length() == 0) {
				curPage = 1;
			} else {
				try {
					curPage = Integer.parseInt(pageString);
					if (curPage > totalPage)
						curPage = totalPage;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			List<Resource> all = rs.queryAllResource(hql, curPage, pageSize);

			ServletActionContext.getRequest().setAttribute("all", all);

			return "showmy";
		}

	}

}
