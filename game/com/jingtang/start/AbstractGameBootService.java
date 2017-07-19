/**
 * @Project: chuanqi
 * @Package: com.jingtang.start
 * @Author: Mr.Gao
 * @Date: 2017年7月13日 下午8:33:11
 * @Since: JDK1.7
 */
package com.jingtang.start;

/**
 * @ClassName: AbstractGameBootService
 * @Description: 游戏服务启动和停止抽象类
 * @Author Mr.Gao
 * @Date: 2017年7月13日 下午8:33:11
 */
public abstract class AbstractGameBootService {

	/**
	 * 
	 * @ClassName: State
	 * @Description: 服务器状态枚举类
	 * @Author Mr.Gao
	 * @Date: 2017年7月13日 下午8:40:43
	 */
	enum State {
		/**
		 * 服务创建
		 */
		STATE_NEW,
		/**
		 * 服务已启动
		 */
		STATE_STARTING,
		/**
		 * 服务运行中
		 */
		STATE_RUNNING,
		/**
		 * 服务已停止
		 */
		STATE_STOPPING,
		/**
		 * 服务已结束
		 */
		STATE_TERMINATED
	}

	/**
	 * @ClassName: ShutdownThread
	 * @Description: 服务器停止处理线程
	 * @Author Mr.Gao
	 * @Date: 2017年7月13日 下午9:08:42
	 */
	static class ShutdownThread extends Thread {
		private final AbstractGameBootService service;

		public ShutdownThread(AbstractGameBootService service) {
			this.service = service;
		}

		@Override
		public void run() {
			if (null != service) {
				service.stop();
			}
		}
	}

	/**
	 * 服务器当前状态
	 */
	private volatile State state = State.STATE_NEW;

	protected final String[] args;

	public AbstractGameBootService(String[] args) {
		this.args = args;
	}

	/**
	 * @Title: onStart
	 * @Description: 启动服务器处理
	 * @param
	 * @return void
	 * @throws
	 */
	protected abstract void onStart();

	/**
	 * @Title: onStop
	 * @Description: 停止服务器处理
	 * @param
	 * @return void
	 * @throws
	 */
	protected abstract void onStop();

	/**
	 * @Title: start
	 * @Description: 启动服务器
	 * @param
	 * @return void
	 * @throws
	 */
	public void start() {
		if (!State.STATE_NEW.equals(state)) {
			return;
		}
		state = State.STATE_STARTING;
		try {
			onStart();
			state = State.STATE_RUNNING;
		} catch (Exception e) {
			System.exit(1);
			return;
		}
	}

	/**
	 * @Title: stop
	 * @Description: 停止服务器
	 * @param
	 * @return void
	 * @throws
	 */
	public void stop() {
		if (!isCanStop()) {
			return;
		}
		state = State.STATE_STOPPING;
		try {
			onStop();
			state = State.STATE_TERMINATED;
		} catch (Exception e) {
			System.exit(1);
			return;
		}
	}

	/**
	 * @Title: getState
	 * @Description: 获取服务器当前状态
	 * @param @return
	 * @return State
	 * @throws
	 */
	public State getState() {
		return state;
	}

	/**
	 * @Title: isStoppingOrTerminated
	 * @Description: 服务器是否可以停机
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean isCanStop() {
		return state != State.STATE_STOPPING && state != State.STATE_TERMINATED;
	}
}
