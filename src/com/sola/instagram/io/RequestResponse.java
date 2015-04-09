package com.sola.instagram.io;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.sola.instagram.exception.InstagramException;

public class RequestResponse {

	String responseString;

	public RequestResponse(String responseAsString) {
		this.responseString = responseAsString;
	}

	public JSONObject getJSON() throws InstagramException, JSONException {
		JSONObject res = null;
		res = new JSONObject(new JSONTokener(getResponseString()));
		isSuccess(res);
		return res;
	}

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	private boolean isSuccess(JSONObject object) throws InstagramException,
			JSONException {
		if (object.has("code")) {
			switch (object.getInt("code")) {
			case 200:
				return true;
			default:
				InstagramException ex = new InstagramException(
						object.getString("error_message"),
						object.getString("error_type"));
				ex.setCode(object.getInt("code"));
				throw ex;
			}
		} else if (object.has("meta")) {
			JSONObject metaObject = object.getJSONObject("meta");
			if (metaObject.has("code")) {
				switch (metaObject.getInt("code")) {
				case 200:
					return true;
				default:
					InstagramException ex = new InstagramException(
							metaObject.getString("error_message"),
							metaObject.getString("error_type"));
					ex.setCode(metaObject.getInt("code"));
					throw ex;
				}
			}
		}
		return true;

	}
}
