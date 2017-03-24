package cn.scxh.carmangger.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.scxh.carmangger.model.Car;
import cn.scxh.carmangger.server.CarServer;
import cn.scxh.carmangger.serverimpl.CarServerImpl;
import cn.scxh.carmangger.utils.Pager;

@Controller
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarServer carServer;

	@RequestMapping("/form")
	public String add() {
		return "/car/add_car";
	}

	// @RequestMapping("/add")
	// public String add2(Car car, Model model) {
	// carServer.addCar(car);
	//
	// return "redirect:/car/show.do";
	// }

	@RequestMapping("/add")
	public String add(Car car, Model model) {
		String type = "carNums";
		String keyword = car.getCarNums();
		System.out.println("keyword:" + keyword);
		ArrayList<Car> lists = (ArrayList<Car>) carServer
				.findCar(type, keyword);
		if (lists != null && lists.size() > 0) {
			model.addAttribute("error", "此车牌号已存在！");
			return "/car/add_car";
		} else {
			carServer.addCar(car);
			return "redirect:/car/show.do";
		}
	}

	/*@RequestMapping("/add")
	public String add(Car car, String telePhone, String carOwnner, Model model) {
		String type = "carNums";
		String keyword = car.getCarNums();
		System.out.println("keyword:" + keyword);
		ArrayList<Car> lists = (ArrayList<Car>) carServer
				.findCar(type, keyword);
		if (lists != null && lists.size() > 0) {
			model.addAttribute("error", "此车牌号已存在！");
			return "/car/add_car";
		}
		String types = "telePhone";
		String keywords = car.getTelePhone();
		System.out.println("keywords:"+keywords);
		ArrayList<Car> list = (ArrayList<Car>) carServer.findCar(types,
				keywords);
		if (list != null && list.size() > 0) {
			for (Car cars : list) {
				System.out.println("cars:" + cars);
				if (cars.getCarOwnner() != carOwnner) {// 如果有电话相同，但车主与现在车主姓名不同
					break;
				}
				System.out.println("111111111" );
			}
			model.addAttribute("error", "您添加的电话号码与其他客户电话号码重复！");
			
			return "/car/add_car";
		}
		carServer.addCar(car);
		return "redirect:/car/show.do";

	}*/

	// @RequestMapping("/show")
	// public String show(Model model) {
	// ArrayList<Car> lists = carServer.showCar();
	// model.addAttribute("lists", lists);
	// return "/car/car_lists";
	// }

	@RequestMapping("/show")
	public String show(Integer page, Model model) {
		int mCurrentPager = 1; // 当前页
		if (page != null && page > 0) {
			mCurrentPager = page;
		}
		Pager pager = new Pager(carServer.getTotalCount(), mCurrentPager);
		pager.setUrl("http://192.168.36.19:8080/car/car/show.do");
		model.addAttribute("url", pager.getPageStr());

		ArrayList<Car> lists = carServer.PagershowCar(pager);
		model.addAttribute("lists", lists);
		return "/car/car_lists";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) {
		carServer.deleteCarById(id);
		return "redirect:/car/show.do";
	}

	/**
	 * 
	 * @param type
	 * @param keyword
	 * @param number
	 * @param model
	 * @return
	 */
	@RequestMapping("/find")
	public String find(String type, String keyword, String number, Model model) {
		System.out.println("keyword:" + keyword + "type:" + type + "carNums:"
				+ number);
		if (type == null && keyword == null) {
			Car car = null;
			type = "carNums";
			keyword = number;
			System.out.println("keyword:" + keyword);
			ArrayList<Car> lists = (ArrayList<Car>) carServer.findCar(type,
					keyword);

			if (lists != null && lists.size() > 0) {
				car = lists.get(0);// 得到唯一值
			}
			model.addAttribute("car", car);
			return "/car/update_car";
		} else {
			ArrayList<Car> lists = (ArrayList<Car>) carServer.findCar(type,
					keyword);
			model.addAttribute("lists", lists);
			return "/car/car_lists";
		}
	}

	@RequestMapping("/update")
	public String update(Car car, Integer id, Model model) {
		System.out.println("111111111car:" + car + "\tid:" + id);
		carServer.updateUser(car, id);
		System.out.println(".>>>>>" + car);
		return "redirect:/car/show.do";

	}
}
