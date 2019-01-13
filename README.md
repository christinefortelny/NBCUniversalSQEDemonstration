# NBCUniversal Testing Craft Demonstration Challenge
Test Cases for the search end point https://images.nasa.gov/docs/images.nasa.gov_api_docs.pdf

Automated test cases are written in java using RestAssured, TestNg, and maven.  Test cases that have been automated are for status codes, q parameter, center parameter, and description parameter.
 
#### Table of Contents  
1. [Test Cases](#test-cases)
   1. [General](#general)
   1. [Status Codes](#status-codes)
   1. [q parameter](#q-parameter)
   1. [center parameter](#center-parameter)
   1. [description parameter](#description-parameter)
   1. [description_508 parameter](#description_508-parameter)
   1. [keywords parameter](#keywords-parameter)
   1. [location parameter](#location-parameter)
   1. [media_type parameter](#media_type-parameter)
   1. [nasa_id parameter](#nasa_id-parameter)
   1. [photographer parameter](#photographer-parameter)
   1. [secondary_creator parameter](#secondary_creator-parameter)
   1. [title parameter](#title-parameter)
   1. [year_start parameter](#year_start-parameter)
   1. [year_end parameter](#year_end-parameter)
   1. [all parameters](#all-parameters)
1. [Response Validations](#response-validations)
1. [Issues Found](#issues-found)

## Test Cases
### General
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
	</tr>
	<tr>
		<td valign="top" align="left">search parameters are not case sensitive</td>
	</tr>
	<tr>
		<td valign="top" align="left">single parameter empty returns error response</td>
	</tr>
	<tr>
		<td valign="top" align="left">leading and trailing spaces in query parameters are ignored</td>
	</tr>
	<tr>
		<td valign="top" align="left">year_start less than four digits</td>
	</tr>
	<tr>
		<td valign="top" align="left">year_end less than four digits</td>
	</tr>
	<tr>
		<td valign="top" align="left">if possible trigger a request that returns a 5XX response code</td>
	</tr>
</table>

### Status Codes
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">Valid request returns 200 response</td>
		<td valign="top" align="left">q=apollo 11 </td>
		<td valign="top" align="left"> response code 200</td>
	</tr>
	<tr>
		<td valign="top" align="left">Request with no parameters returns 400 response</td>
		<td valign="top" align="left">  1 </td>
		<td valign="top" align="left"> response code 400</td>
	</tr>
	<tr>
		<td valign="top" align="left">Request unknown resource returns 404</td>
		<td valign="top" align="left">/assets </td>
		<td valign="top" align="left"> response code 404</td>
	</tr>
</table>

### q parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">search term returns lots of results</td>
		<td valign="top" align="left">q=apollo 11</td>
		<td valign="top" align="left"> 
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">search term returns no results</td>
		<td valign="top" align="left">q=ablahblahblah</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">search term returns less than 100 results</td>
		<td valign="top" align="left">q=aolar eclipse japan</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li> 
		  </ul>
		</td>
	</tr>
</table>


### center parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">center parameter that returns lots of results</td>
		<td valign="top" align="left">center=HQ</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-center-field">result collection item validation center field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">center parameter that returns no results</td>
		<td valign="top" align="left">center=texas</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li> 
		  </ul>
		</td>
	</tr>
</table>

### description parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">description that returns lots of results</td>
		<td valign="top" align="left">description=moon walk </td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-description-field">result collection item validation description field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">description that returns less than 100 results</td>
		<td valign="top" align="left">description=solar eclipse japan</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li>
			<li><a href="#result-collection-item-validation-description-field">result collection item validation description field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">description that returns no results</td>
		<td valign="top" align="left">description=kitten</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li> 
		  </ul>
		</td>
	</tr>
</table>

   
### description_508 parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">description_508 that returns lots of results</td>
		<td valign="top" align="left">description_508=spacecraft</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-description_508-field">result collection item validation description_508 field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">description_508 that returns less than 100 results</td>
		<td valign="top" align="left">description_508=Stratospheric Observatory For Infrared Astronomy</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li>
			<li><a href="#result-collection-item-validation-description-field">result collection item validation description field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">description_508 that returns no results</td>
		<td valign="top" align="left">description_508=kitten</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li>
		  </ul>
		</td>
	</tr>
</table>
  
### keywords parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">keyword that returns lots of results</td>
		<td valign="top" align="left">keywords=moon</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-keywords-array">result collection item validation keywords array</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">keyword that returns less than 100 results</td>
		<td valign="top" align="left">keywords=weather balloon</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li>
			<li><a href="#result-collection-item-validation-keywords-array">result collection item validation keywords array</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">multiple keywords</td>
		<td valign="top" align="left">keywords=moon,weather balloon</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-keywords-array">result collection item validation keywords array</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">keywords that returns no results</td>
		<td valign="top" align="left">keywords=muffin</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li>
			<li><a href="#result-collection-item-validation-keywords-array">result collection item validation keywords array</a></li> 
		  </ul>
		</td>
	</tr>
</table>

### location parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">location that returns lots of results</td>
		<td valign="top" align="left">location=Cape Canaveral, FL</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-location-field">result collection item validation location field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">location that returns less than 100 results</td>
		<td valign="top" align="left">location=Carolina </td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li>
			<li><a href="#result-collection-item-validation-location-field">result collection item validation location field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">location that returns no results</td>
		<td valign="top" align="left">location=main</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#result-collection-item-validation-location-field">result collection item validation location field</a></li> 
		  </ul>
		</td>
	</tr>
</table>

### media_type parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left"> media type that returns lots of results</td>
		<td valign="top" align="left">media_type=image</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-media_type-field">result collection item validation media_type field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">multiple media types</td>
		<td valign="top" align="left">media_type=audio,video</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-media_type-field">result collection item validation media_type field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">media type that returns no results</td>
		<td valign="top" align="left">media_type=movie</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li> 
		  </ul>
		</td>
	</tr>
</table>


### nasa_id parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">nasa_id that returns lots of results</td>
		<td valign="top" align="left">nasa_id=01</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-nasa_id-field">result collection item validation nasa_id field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">nasa_id exact match</td>
		<td valign="top" align="left">nasa_id=KSC-99pd-812-01</td>
		<td valign="top" align="left"> 
		  <ul> 
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-nasa_id-field">result collection item validation nasa_id field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">nasa_id that returns no results</td>
		<td valign="top" align="left">nasa_id=KSC-99pd-812-0112</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li> 
		  </ul>
		</td>
	</tr>
</table>


### photographer parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">photographer single name</td>
		<td valign="top" align="left">photographer=sean</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-photographer-field">result collection item validation photographer field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">photographer full name</td>
		<td valign="top" align="left">photographer=Lee Jones</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-photographer-field">result collection item validation photographer field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">photographer that returns no results</td>
		<td valign="top" align="left">photographer=kitten</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li> 
		  </ul>
		</td>
	</tr>
</table>


### secondary_creator parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">secondary_creator single name</td>
		<td valign="top" align="left">secondary_creator=Smith</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li>
			<li><a href="#result-collection-item-validation-secondary_creator-field">result collection item validation secondary_creator field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">secondary_creator that returns no results</td>
		<td valign="top" align="left">secondary_creator=jones</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li> 
		  </ul>
		</td>
	</tr>
</table>

### title parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">title that returns lots of results</td>
		<td valign="top" align="left">title=moon</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-title-field">result collection item validation title field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">title that returns less than 100 results</td>
		<td valign="top" align="left">title=muffin</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li>
			<li><a href="#result-collection-item-validation-title-field">result collection item validation title field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">title multiple terms separated by space</td>
		<td valign="top" align="left">title=moon eclipse</td>
		<td valign="top" align="left"> 
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-title-field">result collection item validation title field</a></li>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">title multiple terms separated by comma</td>
		<td valign="top" align="left">title=moon,eclipse </td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-title-field">result collection item validation title field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">title that returns no results</td>
		<td valign="top" align="left">title=kitten/td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li> 
		  </ul>
		</td>
	</tr>
</table>


### year_start parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">year start that returns results</td>
		<td valign="top" align="left">year_start=2018</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-year_start-date_created-field">result collection item validation year_start date_created field</a></li> 
		  </ul>
		</td>
	</tr>
	<tr>
		<td valign="top" align="left">year start that no results</td>
		<td valign="top" align="left">year_start=3030</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li>
		  </ul>
		</td>
	</tr>
</table>

### year_end parameter
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">year end that returns results</td>
		<td valign="top" align="left">year_end =2018</td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-zero">total hits zero</a></li>
			<li><a href="#collection-links-present">collection links present</a></li>
			<li><a href="#result-collection-item-validation-year_end-date_created-field">result collection item validation year_end date_created field</a></li> 
		  </ul>
		</td>
	</tr>
</table>


### all parameters
<table valign="top">
	<tr>
		<th valign="top" align="left">Description</th>
    	<th valign="top" align="left">request parameters</th> 
    	<th valign="top" align="left">validations</th>
	</tr>
	<tr>
		<td valign="top" align="left">search that uses all parameters</td>
		<td valign="top" align="left">
			q=Aeronautics<br>
			center=ARC
			description=wind tunnel<br>
			description_508=Airplane<br>
			keywords=Douglas<br>
			location=ames<br>
			media_type=image<br>
			nasa_id=A-<br>
			photographer=NACA<br>
			secondary_creator=Richey<br>
			title=wind<br>
			year_start=1940<br>
			year_end=1950
		 </td>
		<td valign="top" align="left">  
		  <ul>
			<li><a href="#standard-response-validation">standard response validation</a></li>
			<li><a href="#total-hits-greater-than-zero">total hits greater than zero</a></li>
			<li><a href="#collection-links-not-present">collection links not present</a></li>
			<li><a href="#result-collection-item-validation-center-field">result collection item validation center field</a></li>
			<li><a href="#result-collection-item-validation-description-field">result collection item validation description field</a></li>
			<li><a href="#result-collection-item-validation-description_508-field">result collection item validation description_508 field</a></li>
			<li><a href="#result-collection-item-validation-keywords-array">result collection item validation keywords array</a></li>
			<li><a href="#result-collection-item-validation-location-field">result collection item validation location field</a></li>
			<li><a href="#result-collection-item-validation-media_type-field">result collection item validation media_type field</a></li>
			<li><a href="#result-collection-item-validation-nasa_id-field">result collection item validation nasa_id field</a></li>
			<li><a href="#result-collection-item-validation-photographer-field">result collection item validation photographer field</a></li>
			<li><a href="#result-collection-item-validation-secondary_creator-field">result collection item validation secondary_creator field</a></li>
			<li><a href="#result-collection-item-validation-title-field">result collection item validation title field</a></li>
			<li><a href="#result-collection-item-validation-year_start-date_created-field">result collection item validation year_start date_created field</a></li>
			<li><a href="#result-collection-item-validation-year_end-date_created-field">result collection item validation year_end date_created field</a></li> 
		  </ul>
		</td>
	</tr>
</table>

## Response Validations
Validations to be run for tests that have success response

### Standard Response Validation
* validate schema
* validate response code 200
* `collection` field is present
   * `collection.version` is present with value of "1.0"
   * `collection.items` is present
   * `collection.metadata` is present
      * `collection.metadata.total_hits` is present
   * `collection.href` equals search url

### total hits greater than zero
* validate `collection.metadata.total_hits` is greater than zero

### total hits zero
* validate `collection.metadata.total_hits` equals zero


### collection links present
* validate `collection.links` exists

### collection links not present
* validate `collection.links` does not exist

### result collection item validation center field
 * validate for each `collection.items[<index>].data[<index>].center` exists
 * validate for each `collection.items[<index>].data[<index>].center` equals center parameter

### result collection item validation description field
 * validate for each `collection.items[<index>].data[<index>].description` exists
 * validate for each `collection.items[<index>].data[<index>].description` contains description parameter

### result collection item validation description_508 field
 * validate for each `collection.items[<index>].data[<index>].description_508` exists
 * validate for each `collection.items[<index>].data[<index>].description_508` contains description parameter
 
### result collection item validation keywords array
 * validate for each `collection.items[<index>].data[<index>].keywords[]` exists
 * validate for each `collection.items[<index>].data[<index>].keywords[]` contains at least one entry that contains on of the provided keywords

### result collection item validation location field
 * validate for each `collection.items[<index>].data[<index>].location` exists
 * validate for each `collection.items[<index>].data[<index>].location` contains location parameter

### result collection item validation media_type field
 * validate for each `collection.items[<index>].data[<index>].media_type` exists
 * validate for each `collection.items[<index>].data[<index>].media_type` equals one of the media_type parameters

### result collection item validation nasa_id field
 * validate for each `collection.items[<index>].data[<index>].nasa_id` exists
 * validate for each `collection.items[<index>].data[<index>].nasa_id` contains the nasa_id parameter

### result collection item validation photographer field
 * validate for each `collection.items[<index>].data[<index>].photographer` exists
 * validate for each `collection.items[<index>].data[<index>].photographer` contains photographer parameter

### result collection item validation secondary_creator field
 * validate for each `collection.items[<index>].data[<index>].secondary_creator` exists
 * validate for each `collection.items[<index>].data[<index>].secondary_creator` contains secondary_creator parameter

### result collection item validation title field
 * validate for each `collection.items[<index>].data[<index>].title` exists
 * validate for each `collection.items[<index>].data[<index>].title` contains each of the title parameters

### result collection item validation year_start date_created field
 * validate for each `collection.items[<index>].data[<index>].date_created` exists
 * validate for each `collection.items[<index>].data[<index>].date_created` year is greater than or equal to year_start parameter
 
### result collection item validation year_end date_created field
 * validate for each `collection.items[<index>].data[<index>].date_created` exists
 * validate for each `collection.items[<index>].data[<index>].date_created` year is less than or equal to year_end parameter 
 


## Issues Found
* Searching description for "puppy".  Search results were returned that include descriptions that do not contain "puppy"
* For media type the spec lists available types  [“image”, “audio”].  "video" is also being returned and supported
* result with nasa_id LRC-1962-B701_P-03646 has date_created of "0962-05-09T00:00:00Z"

