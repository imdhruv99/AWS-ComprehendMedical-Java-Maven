package com.awscomprehendmedical.AWSComprehendMedical;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.comprehendmedical.AWSComprehendMedical;
import com.amazonaws.services.comprehendmedical.AWSComprehendMedicalClient;
import com.amazonaws.services.comprehendmedical.model.DetectEntitiesRequest;
import com.amazonaws.services.comprehendmedical.model.DetectEntitiesResult;
import com.google.gson.Gson;

public class AWSComprehendDemo {

	public static void main(String args[]) {

		String text = "Pt is 87 yo woman, highschool teacher with past medical history that includes   "
				+ "- status post cardiac catheterization in April 2019.She presents today"
				+ " with palpitations and chest pressure.HPI : Sleeping trouble on present dosage of Clonidine."
				+ " Severe Rash  on face and leg, slightly itchy  Meds : Vyvanse 50 mgs po at breakfast daily,  "
				+ " Clonidine 0.2 mgs -- 1 and 1 / 2 tabs po qhs HEENT : Boggy inferior turbinates, "
				+ "No oropharyngeal lesion Lungs : clear Heart : Regular rhythm Skin : "
				+ " Mild erythematous eruption to hairline Follow-up as scheduled";

		// Put you access key and secret key here
		AWSCredentials credentials = new BasicAWSCredentials("",
				"VNwzmbNqpHnxCWAjD+");

		EndpointConfiguration endpointConfiguration = new EndpointConfiguration(
				"https://comprehendmedical.us-east-1.amazonaws.com", "us-east-1");

		AWSComprehendMedical client = AWSComprehendMedicalClient.builder()
				.withEndpointConfiguration(endpointConfiguration)
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).build();

		DetectEntitiesRequest request = new DetectEntitiesRequest();
		request.setText(text);

		DetectEntitiesResult result = client.detectEntities(request);
		System.out.println("\n -------------------- Data ---------------------- \n");
		String resultData = new Gson().toJson(result);
		System.out.println(resultData);
	}
}
