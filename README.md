# ocr-cloud-detection
A OCR cloud service API for OCR extraction using cloud managed services powered by AWS, Azure &amp; GCP.


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
		<td> Languages Supported </td>
		<td> only ENG </td>
		<td> 25 Languages </td>
		<td> 25 Languages </td>
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
      <tr>		
		<td> Pricing </td>
		<td> 
			<ul>
				<li> Cost per image 0-1M $0.01 </li> 
				<li> Cost for first 1M images per month $0.001*1,000,000=$1,000 </li>
				<li> Cost per image 1M-10M $0.0008 </li> 
			</ul> 
	    </td>
		<td> 
			<ul>
				<li> 0-1M transactions — $1 per 1,000 transactions</li> 
				<li> 1M-5M transactions — $0.80 per 1,000 transactions  </li>
				<li> 5M-10M transactions — $0.65 per 1,000 transactions   </li> 
				<li> E10M-100M transactions — $0.65per 1,000 transactions </li>
				<li> 100M+ transactions — $0.65 per 1,000 transactions    </li> 			
			</ul> 
	    </td>
		<td> 
			<ul>
				<li> First 1000 untis - Free  </li> 
				<li> Units 1001 - 5,000,000 / month - $1.50  </li>
				<li>  Units 5,000,001 - 20,000,000 / month - $1 </li> 					
			</ul> 
	    </td>
    </tr>    
</table>

## Environment Setup

- Set up environment variables before you start the application

```
SPRING_CLOUD_GCP_CREDENTIALS_LOCATION=<< path to GCP credentails location containing keys >>
SPRING_CLOUD_GCP_CREDNETIALS_SCOPES=DEFAULT_SCOPES,https://www.googleapis.com/auth/cloud-vision
AZURE_ENDPOINT_URL=<< Azure computer vision api location service url >>
AZURE_SUBSCRIPTION_ID=<< Azure computer vision service subscription keys >>
AWS_ACCESS_KEY=<< AWS subscription access key to service >>
AWS_SECRET_KEY=<< AWS subscription secret key to service >>
```
- Spring Profile support to enable/disable particular cloud provider service

```
spring.profiles.active=aws # possible values aws | gcp | azure or all three aws,gcp,azure.
```
