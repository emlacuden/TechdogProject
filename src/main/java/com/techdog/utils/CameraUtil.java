package com.techdog.utils;

import java.awt.Image;

import io.evercam.*;

public class CameraUtil {
	public void saveSnapShot() {
		Camera camera = Camera.create(new CameraBuilder("cameraid", // unique identifier
				true) // is public or not
						.setJpgUrl("/Streaming/channels/1/picture").setCameraUsername("username")
						.setCameraPassword("password").setExternalHost("89.101.225.158").setExternalHttpPort(80)
						.setLocation(latitude, longtitute).build());
	}
}
