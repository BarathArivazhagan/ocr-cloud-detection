# ocr-cloud-detection
A OCR cloud service API to try out OCR text detection using cloud managed services powered by AWS, Azure &amp; GCP.


## Comparison Analysis

<table>
	<tr>
		<th>Features/Characteristics </th>
		<th> AWS </th>
		<th> Azure</th>
		<th> GCP </th>
    </tr>
    <tr>		
		<td> Service </td>
		<td> AWS Rekognition </td>
		<td> Azure Cognitive Service</td>
		<td> Google Cloud Vision </td>
    </tr>
      <tr>		
		<td> Service </td>
		<td> AWS Rekognition </td>
		<td> Azure Cognitive Service</td>
		<td> Google Cloud Vision </td>
    </tr>    
      <tr>		
		<td> Service </td>
		<td> AWS Rekognition </td>
		<td> Azure Cognitive Service</td>
		<td> Google Cloud Vision </td>
    </tr>    
     <tr>		
		<td> OCR </td>
		<td> Yes </td>
		<td> Yes </td>
		<td> Yes </td>
    </tr>
    <tr>		
		<td> Handwritten </td>
		<td> Yes (Better with AWS Texextract)</td>
		<td> Yes </td>
		<td> Yes </td>
    </tr>
    <tr>		
		<td> Available Regions </td>
		<td> 
			<ul>
				<li>US East (Northern Virginia) </li> 
				<li> US West (Oregon) </li>
				<li> US East (Ohio) </li> 
				<li> EU (Ireland) </li>
				<li> Asia Pacific (Tokyo) </li> 
				<li> Asia Pacific (Sydney) </li>
				<li> Asia Pacific (Mumbai) </li> 
				<li>Asia Pacific (Seoul) </li> 
				<li> AWS GovCloud (US) regions</li>
			</ul> 
	    </td>
		<td> 
			<ul>
				<li> West US </li> 
				<li> West US 2 </li>
				<li> East US  </li> 
				<li> East US 2 </li>
				<li> West Central US </li> 
				<li> South Central US </li> 
				<li> Southeast Asia </li>
				<li> West Europe  </li> 
			    <li> North Europe </li>
				<li> East Asia  </li> 
			    <li> Australia East </li>
				<li> Brazil South</li> 
				<li> Canada Central </li>
				<li>Central India  </li> 
				<li> UK South  </li> 
				<li> Japan East </li>
			</ul> 
	    </td>
		<td> 
			<ul>
				<li>North America </li> 
				<li>  South America </li>
				<li> Europe </li> 
				<li> Asia </li>
				<li> Australia </li>				
			</ul> 
	    </td>
    </tr>
    


</table>

## Environment Setup

> Set up environment variables before you start the application

```
SPRING_CLOUD_GCP_CREDENTIALS_LOCATION=<< path to GCP credentails location containing keys >>
SPRING_CLOUD_GCP_CREDNETIALS_SCOPES=DEFAULT_SCOPES,https://www.googleapis.com/auth/cloud-vision
AZURE_ENDPOINT_URL=<< Azure computer vision api location service url >>
AZURE_SUBSCRIPTION_ID=<< Azure computer vision service subscription keys >>
AWS_ACCESS_KEY=<< AWS subscription access key to service >>
AWS_SECRET_KEY=<< AWS subscription secret key to service >>
```
