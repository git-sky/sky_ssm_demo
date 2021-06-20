package cn.com.sky.src.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Exams;
import org.apache.struts2.ServletActionContext;
import service.interfaces.ScoreService;
import service.interfaces.TestbankService;
import entity.Chapter;
import entity.Score;
import entity.Testbank;
import entity.Users;

public class TestbankAction extends BaseAction {

	// 注入依赖
	private TestbankService ts;

	private ScoreService ss;

	int chapterid;

	public void setSs(ScoreService ss) {
		this.ss = ss;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	List<Chapter> alltype;
	int grade = 0;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	List<Exams> tests;

	public List<Exams> getTests() {
		return tests;
	}

	public void setTests(List<Exams> tests) {
		this.tests = tests;
	}

	public List<Chapter> getAlltype() {
		return alltype;
	}

	public void setAlltype(List<Chapter> alltype) {
		this.alltype = alltype;
	}

	public void setTs(TestbankService ts) {
		this.ts = ts;
	}

	// 模型驱动
	Testbank testbank = new Testbank();

	public String add() {

		String param = ServletActionContext.getRequest().getParameter("param");
		if (param == null) {
			try {
				alltype = ts.queryAllChapter();
				ServletActionContext.getRequest().setAttribute("alltype",
						alltype);
				setAlltype(alltype);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		} else {

			Chapter c = new Chapter();
			String chapterid = ServletActionContext.getRequest().getParameter(
					"chapterid");
			c.setChapterid(Integer.parseInt(chapterid));

			c.setName(ts.queryChapterById(Integer.parseInt(chapterid))
					.getName());
			testbank.setChapter(c);
			ts.addTestbank(testbank);
			return "insert";
		}
	}

	public String showall() {

		alltype = ts.queryAllChapter();
		setAlltype(alltype);
		String title = ServletActionContext.getRequest().getParameter(
				"testbanktitle");

		if (null != title) {
			ServletActionContext.getRequest().getSession().setAttribute(
					"title", title);
		}

		String chapterid = ServletActionContext.getRequest().getParameter(
				"chapterid");

		if (null != chapterid) {
			Chapter chapter = ts.queryChapterById(Integer.parseInt(chapterid));

			ServletActionContext.getRequest().getSession().setAttribute(
					"chapter", chapter);
		}

		String condition = ServletActionContext.getRequest().getParameter(
				"condition");

		if (condition != null) {
			if (null != title && null != chapterid) {

				if (null == title) {
					ServletActionContext.getRequest().getSession()
							.setAttribute("title", "");
				}

				if (Integer.parseInt(chapterid) == 0) {

					ServletActionContext.getRequest().getSession()
							.setAttribute(
									"condition",
									"from Testbank testbank where testbank.title like '%"
											+ title + "%'");
				} else {

					ServletActionContext
							.getRequest()
							.getSession()
							.setAttribute(
									"condition",
									"from Testbank testbank where testbank.title like '%"
											+ title
											+ "%' and testbank.chapter.chapterid = '"
											+ chapterid + "'");
				}
			} else {
				ServletActionContext.getRequest().getSession().removeAttribute(
						"condition");
				ServletActionContext.getRequest().getSession().removeAttribute(
						"title");
				ServletActionContext.getRequest().getSession().removeAttribute(
						"chapter");

				// 
				ServletActionContext.getRequest().getSession().setAttribute(
						"condition", "from Testbank");
				ServletActionContext.getRequest().getSession().setAttribute(
						"title", "");
			}
		}

		String hql = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("condition");

		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

		totalCount = ts.getTotalCount(hql);

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

		List<Testbank> all = ts.queryAllTestbank(hql, curPage, pageSize);

		ServletActionContext.getRequest().setAttribute("all", all);

		return "show";

	}

	public String update() throws Exception {

		String testid = ServletActionContext.getRequest()
				.getParameter("testid");

		String chapterid = ServletActionContext.getRequest().getParameter(
				"chapterid");

		alltype = ts.queryAllChapter();

		setAlltype(alltype);

		Testbank testbank = ts.queryTestbankById(Integer.parseInt(testid));

		Chapter chapter = ts.queryChapterById(Integer.parseInt(chapterid));

		String page = ServletActionContext.getRequest().getParameter("page");

		ServletActionContext.getRequest().setAttribute("page", page);

		ServletActionContext.getRequest().setAttribute("testbank", testbank);

		ServletActionContext.getRequest().setAttribute("chapter", chapter);

		return "update";

	}

	public String updatesubmit() {

		try {
			int chapterid = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("chapterid2"));

			Chapter chapter = new Chapter();

			chapter.setChapterid(chapterid);

			testbank.setChapter(chapter);

			ts.updateTestbank(testbank);

			return showall();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return showall();

	}

	public String delete() {
		String testid = ServletActionContext.getRequest()
				.getParameter("testid");

		ts.deleteTestbank(Integer.parseInt(testid));

		return showall();

	}

	// 存放试题的list

	@SuppressWarnings("unchecked")
	public String generate() {
		int num = 0;
		chapterid = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("chapterid"));

		// 所抽取的题目的数量
		num = Integer.parseInt(ServletActionContext.getRequest().getParameter(
				"num"));

		// 存放结果，无重复
		tests = new ArrayList<Exams>();

		String hql = "from Testbank as testbank where testbank.chapter.chapterid='"
				+ chapterid + "'";

		// 查出所有符合条件的数据。
		List<Testbank> list = ts.generate(hql);

		int maxSize = list.size();

		// 存放随机生成的数字
		Set<Integer> set = new HashSet<Integer>();

		if (maxSize < num) {
			return "json2";
		} else {
			// 把随机数字放入set中
			while (true) {
				int randNumber = (int) (Math.random() * maxSize + 1) - 1;
				set.add(randNumber);
				System.out.print(randNumber + " ");
				if (set.size() >= num)
					break;
			}
			System.out.println();
			for (int randNumber : set) {
				Exams test = new Exams();

				test.setTestid(list.get(randNumber).getTestid());
				test.setTitle(list.get(randNumber).getTitle());
				test.setA(list.get(randNumber).getA());
				test.setB(list.get(randNumber).getB());
				test.setC(list.get(randNumber).getC());
				test.setD(list.get(randNumber).getD());
				test.setAnswer(list.get(randNumber).getAnswer());

				tests.add(test);

				System.out.print(randNumber + " ");

			}
		}
		// setResults(results);
		setTests(tests);

		// ServletActionContext.getRequest().setAttribute("all", results);

		return "json2";

	}

	public String handin() {

		// 考试所得的分数

		// String scoreid = ServletActionContext.getRequest().getParameter(
		// "scoreid");

		// 初始化成绩为0
		grade = 0;
		for (int i = 0; i < tests.size(); i++) {

			//用户选择的答案
			String[] u = ServletActionContext.getRequest().getParameterValues(
					tests.get(i).getTestid().toString());

			StringBuilder builder = new StringBuilder();
			for (int j = 0; null!=u&&j < u.length; j++) {
				builder.append(u[j]);
			}
			String str = builder.toString();
			System.out.println("用户选择的答案"+str);
			
			//把正确的答案进行分割，逗号和空格都不能丢。
			String[] ans=tests.get(i).getAnswer().toString().split(", ");

			StringBuilder builder2 = new StringBuilder();
			for (int k = 0; null!=ans&&k < ans.length; k++) {
				builder2.append(ans[k]);
			}
			String str2 = builder2.toString();
			System.out.println("正确的答案"+str2);

			
			if (str.equalsIgnoreCase(str2)) {
				grade = grade + 30 / tests.size();
			}

		}

		// 用于返回给客户端
		setGrade(grade);

		// ServletActionContext.getRequest().setAttribute("grade", grade);

		// 将考试的记录存入数据库中
		Score score = new Score();
		score.setGrade(grade);

		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		score.setUsers(user);

		Chapter chapter = new Chapter();
		chapter.setChapterid(chapterid);

		score.setChapter(chapter);

		score.setDate(sdf.format(new Date()));

		ss.addScore(score);

		return "json3";

	}

	@Override
	public Testbank getModel() {
		return testbank;
	}

}
