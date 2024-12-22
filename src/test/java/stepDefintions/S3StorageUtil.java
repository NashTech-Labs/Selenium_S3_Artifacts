package stepDefintions;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;

public class S3StorageUtil {

    private static final String BUCKET_NAME = "test.artifacts";
    private static final String REGION = "us-east-1";
    private static final String ACCESS_KEY = "MY-ACCESS-KEY";
    private static final String SECRET_KEY = "MY-SECRET-KEY";

    BasicAWSCredentials awsCreds = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .withRegion(REGION)
            .build();
    File file = new File("target/surefire-reports");
        public S3StorageUtil() {

            uploadFile(s3Client, BUCKET_NAME, file);
        }

    public static void uploadFile(AmazonS3 s3Client, String bucketName, File file) {
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                uploadFile(s3Client, bucketName, subFile);
            }
        } else {
            String keyName = file.getName();
            s3Client.putObject(new PutObjectRequest(bucketName, keyName, file.getAbsolutePath()));
            System.out.println("Uploaded: " + keyName);
        }
    }

}
