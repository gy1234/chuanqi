/**
 * @Project: chuanqi
 * @Package: com.jingtang.start
 * @Author: Mr.Gao
 * @Date: 2017年7月19日 下午8:23:07
 * @Since: JDK1.7
 */
package com.jingtang.start;

/**
 * @ClassName: GameBootService
 * @Author Mr.Gao
 * @Date: 2017年7月19日 下午8:23:07
 */
public class GameBootService extends AbstractGameBootService {

	/** 
	 * Creates a new instance of GameBootService.
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * @param args 
	 */
	public GameBootService(String[] args) {
		super(args);
	}

	/**
	 * <p>Title: onStart</p>
	 * <p>Description: </p>
	 * @see com.jingtang.start.AbstractGameBootService#onStart()
	 */
	@Override
	protected void onStart() {
		//1.加载配置
		//2.游戏策划配置下载到本地
		//3.spring业务组件初始化
		//4.netty通信组件初始化
		//5.验证数据库表和代码是否同步 配置里有可控制是否开启,验证跨服不开启表结构验证
		//6.连接redis
		//7.服务器信息初始化
		//8.生成唯一id的服务
		//9.http通信组件初始化
		//10.解析游戏最大人数和IP白名单属性配置
		//11.启动内存监控
		//12.热发布配置下载并解析
		//13.游戏业务启动处理
		//14.打开主端口消息入口
		//15.记录进程ID
		//16.输出成功信息
	}

	/**
	 * <p>Title: onStop</p>
	 * <p>Description: </p>
	 * @see com.jingtang.start.AbstractGameBootService#onStop()
	 */
	@Override
	protected void onStop() {
		// 1.关闭主端口消息入口
		// 2.关闭http通信组件
		// 3.关闭netty通信组件
		// 4.netty通信组件初始化
		// 5.redis注销
		// 6.游戏业务关闭处理
		// 7.游戏业务数据回写
		// 8.输出成功信息
	}

}
