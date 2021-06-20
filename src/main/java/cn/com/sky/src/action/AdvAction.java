package cn.com.sky.src.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import service.interfaces.AdvService;
import entity.Adv;

/*
 * 公告模块
 * 
 * 模型驱动
 */
public class AdvAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private AdvService ads;

	Adv adv = new Adv();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void setAds(AdvService ads) {
		this.ads = ads;
	}


	public String add() {

		String date = sdf.format(new Date());
		adv.setDate(date);
		ads.addAdv(adv);
		return "insert";
	}

	public String updatesubmit() {
		String date = sdf.format(new Date());
		adv.setDate(date);
		ads.updateAdv(adv);
		return showall();
	}

	public String update() {

		String advid = ServletActionContext.getRequest().getParameter("advid");

		Adv adv = ads.queryAdvById(Integer.parseInt(advid));

		ServletActionContext.getRequest().setAttribute("adv", adv);

		return "update";

	}
	
	public String show() {

		update();

		return "show";

	}

	public String delete() {
		String advid = ServletActionContext.getRequest().getParameter("advid");
		ads.deleteAdv(Integer.parseInt(advid));
		return showall();

	}

	//管理员查看公告
	public String showall() {

		List<Adv> advs = ads.queryAll();

		ServletActionContext.getRequest().setAttribute("all", advs);

		return SUCCESS;
	}
	
	//index.jsp显示公告
	public String showsome() {

	showall();

		return "some";
	}

	@Override
	public Adv getModel() {
		return adv;
	}
}
