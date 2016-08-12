package model;

import java.util.List;


@SuppressWarnings("serial")
public class SysMenuBean extends SysMenu {
	private List<SysMenuBean> menuBeans;

	public List<SysMenuBean> getMenuBeans() {
		return menuBeans;
	}

	public void setMenuBeans(List<SysMenuBean> menuBeans) {
		this.menuBeans = menuBeans;
	}
}
