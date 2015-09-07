package com.corejava.dp;

public class TemplateMethodDP {

	public static void main(String[] args) {
		Service hTTPService = new HTTPService();
		hTTPService.play();
		Service fTPService = new FTPService();
		fTPService.play();
	}

}

abstract class Service {

	abstract void init();

	abstract void service();

	abstract void destroy();

	public final void play() {
		init();
		service();
		destroy();
	}
}

class HTTPService extends Service {

	@Override
	void init() {
		System.out.println("HTTPService.init()");
	}

	@Override
	void service() {
		System.out.println("HTTPService.service()");
	}

	@Override
	void destroy() {
		System.out.println("HTTPService.destroy()");
	}
}

class FTPService extends Service {

	@Override
	void init() {
		System.out.println("FTPService.init()");
	}

	@Override
	void service() {
		System.out.println("FTPService.service()");
	}

	@Override
	void destroy() {
		System.out.println("FTPService.destroy()");
	}

}