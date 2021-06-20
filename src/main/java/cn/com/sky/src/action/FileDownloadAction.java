package cn.com.sky.src.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.struts2.ServletActionContext;

import service.interfaces.ResourceService;

import entity.Resource;

public class FileDownloadAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private ResourceService rs;

	public void setRs(ResourceService rs) {
		this.rs = rs;
	}

	String name; // 指定要被下载的文件的名称

	private String inputPath;// 指定要被下载的文件的真实路径

	// 使用注入依赖方法，通过struts.xml配置文件得到inputPath
	public void setInputPath(String inputPath) {
		System.out.println("注入依赖" + inputPath);
		this.inputPath = inputPath;
	}

	/*
	 * 该方法用于得到输入流
	 */
	public InputStream getTargetFile() throws Exception {

		System.out.println("输入流");
		// 通过传递过来的参数得到资源的实际的名称
		name = ServletActionContext.getRequest().getParameter("fn");

		// 统计下载次数
		String resourceid = ServletActionContext.getRequest().getParameter(
				"resourceid");

		Resource resource = rs.queryResourceById(Integer.parseInt(resourceid));

		resource.setDowncount(resource.getDowncount() + 1);

		rs.updateResource(resource);

		System.out.println("转码前" + name);
		// 转码
		name = new String(name.getBytes("iso-8859-1"), "utf-8");

		System.out.println("转码后" + name);
		// 要下载的文件的路径和名称
		inputPath = inputPath + name;
		System.out.println("转码后路径" + inputPath);
		// 得到输入流
		return ServletActionContext.getServletContext().getResourceAsStream(
				inputPath);

	}

	public String execute() throws Exception {
		System.out.println("execute方法");

		// 如果没有登录，没有下载的权限，返回登录界面
		if (null == ServletActionContext.getRequest().getSession()
				.getAttribute("user")
				&& null == ServletActionContext.getRequest().getSession()
						.getAttribute("admin")) {
			return LOGIN;
		}

		return SUCCESS;
	}

	/*
	 * 提供转换编码后的供下载用的文件名
	 */
	public String getDownloadFileName() {

		System.out.println("下载文件名");

		String downname = name;

		try {
			System.out.println("转码下载前" + name);

			// 转码
			name = new String(name.getBytes(), "iso8859-1");
			// 取得文件的真实的名称，不包括路径。
			downname = name.substring(name.lastIndexOf("/") + 1);

			System.out.println("转码下载 后" + downname);

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		return downname;

	}

}
