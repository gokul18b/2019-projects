package com.kgfsl.ecampusstudent.Modal.about;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonReader {

	public static List<ImagesModal> getHome(JSONObject jsonObject)
			throws JSONException {
		List<ImagesModal> products = new ArrayList<ImagesModal>();

		JSONArray jsonArray = jsonObject.getJSONArray("products");
		ImagesModal ImagesModal;
		for (int i = 0; i < jsonArray.length(); i++) {
			ImagesModal = new ImagesModal();
			JSONObject productObj = jsonArray.getJSONObject(i);
			ImagesModal.setId(productObj.getInt("id"));
			ImagesModal.setName(productObj.getString("name"));
			ImagesModal.setImageUrl(productObj.getString("image_url"));
			products.add(ImagesModal);
		}
		return products;
	}
}
