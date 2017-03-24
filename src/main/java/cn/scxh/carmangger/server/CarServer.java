package cn.scxh.carmangger.server;

import java.util.ArrayList;
import java.util.List;

import cn.scxh.carmangger.model.Car;
import cn.scxh.carmangger.utils.Pager;

public interface CarServer {
	public abstract void addCar(Car car);
	
	public abstract ArrayList<Car> showCar();
	public abstract ArrayList<Car> PagershowCar(Pager pager);
	public int getTotalCount();
	
	void deleteCarById(int id);
	
	public abstract void updateUser(Car car, int id);// 抽象方法
	
	public abstract Car findCarByCarNum(String carNum);
	
	public abstract List<Car> findCar(String type,String keyword);
}
