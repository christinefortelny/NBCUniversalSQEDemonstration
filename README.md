# Christine Fortelny NBCUniversal Testing Craft Demonstration Challenge



## Test Cases
### Status Codes
* Valid request returns 200 response
* Request with no parameters returns a 400
* Request unknown resource returns 404
* Server error returns a 5XX response code.  (Figure out if there is a way to trigger this)

### Other
* search parameters are not case sensitive
* single parameter empty returns error response
* leading and trailing spaces in query parameters are ignored
* year_start less than four digits
* year_end less than four digits





### Standard Response Validation
* validate schema
* validate response code 200
* collection field is present
   * collection.version is present with value of "*0"
   * collection.items is present
   * collection.metadata is present
      * collection.metadata.total_hits is present
      * collection.metadata.total_hits is zero when no results expected
      * collection.metadata.total_hits is greater than zero when results expected
   * collection.href is present with value of the request url
   * collection.links is present when more than 100 results expected
   

### q parameter (search term)
* search term that returns lots of results, **apollo 11**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
* search term that returns no results, **blahblahblah**
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present
* search term that returns less than 100 results, **solar eclipse japan**
   * execute standard response validation
   * collection.metadata.total_hits is greater than zero
   * collection.links is not present

### center parameter (NASA center)
* center parameter that returns lots of results, **HQ**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].center equals center parameter
* center parameter that returns no results, **texas**
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present
   
### description
* description that returns lots of results, **moon walk**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].description contains description parameter
* description that returns less than 100 results, **solar eclipse japan**
   * execute standard response validation
   * collection.metadata.total_hits is greater than zero
   * collection.links is not present
    * for each collection.items[<index>].data[<index>].description contains description parameter
* description that returns no results, **texas**
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present
   
### description_508
* description_508 that returns lots of results, **spacecraft**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].description_508 contains description_508 parameter
* description_508 that returns less than 100 results, **Stratospheric Observatory For Infrared Astronomy**
   * execute standard response validation
   * collection.metadata.total_hits is greater than zero
   * for each collection.items[<index>].data[<index>].description_508 contains description_508 parameter
   * collection.links is not present    
* description_508 that returns no results, **kitten**
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present
    
### keywords
* keyword that returns lots of results, **moon**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].keywords[] contains at least one entry that contains the keyword
* keyword that returns less than 100 results, **weather balloon**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].keywords[] contains at least one entry that contains the keyword
* multiple keywords **moon,weather balloon**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].keywords[] contains at least one entry that contains at least one of the keywords
* keywords that returns no results, **muffin*
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present

### location
* location that returns lots of results, **Cape Canaveral, FL**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].location contains location parameter
* location that returns no results, **main**
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present
* location that returns less than 100 results, *Carolina**
   * execute standard response validation
   * collection.metadata.total_hits is greater than zero
   * collection.links is not present
   * for each collection.items[<index>].data[<index>].location contains location parameter
    
### media_type
* media type that returns lots of results, **image**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].media_type equals media_type parameter
* multiple media types *audio,video**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].media_type equals one of the media_type parameters
* media type that returns no results, **movie*
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present

### nasa_id
* nasa_id that returns lots of results, **01**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].nasa_id contains the nasa_id parameter
* nasa_id exact match, **KSC-99pd-812-01**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].nasa_id equals nasa_id parameter
* nasa_id that returns no results, **KSC-99pd-812-0112*
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present

 * collection.links is not present

### photographer
* photographer single name, **sean**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].photographer contains photographer parameter
* photographer full name, **Lee Jones**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].photographer contains photographer parameter
* photographer that returns no results, **kitten*
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present

### secondary_creator
* secondary_creator single name, **Smith**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is not present
    * for each collection.items[<index>].data[<index>].secondary_creator contains secondary_creator parameter
* secondary_creator that returns no results, **jones*
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present


### title
* title that returns lots of results, **moon**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].title contains the title parameter
* title that returns less than 100 results, **muffin**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].title contains the title parameter
* title multiple terms separated by space **moon eclipse**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].title contains each of the title parameters
* title multiple terms separated by comma **moon,eclipse**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].title contains each of the title parameters
* title that returns no results, **kitten*
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present

### year_start
* year start that returns results, **2018**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].date_created year is greater than or equal to year_start parameter
* year start that no results, **3030*
   * execute standard response validation
   * collection.metadata.total_hits is zero
   * collection.links is not present


### year_end
* year end that returns results, **2018**
    * execute standard response validation
    * collection.metadata.total_hits is greater than zero
    * collection.links is present
    * for each collection.items[<index>].data[<index>].date_created year is less than or equal to year_end parameter

### all parameters
* search that uses all parameters
    * execute standard response validation
    * for each collection items validate that each of the search parameters matches




## Issues
* Searching description for "puppy".  Search results were returned that include descriptions that do not contain "puppy"
* For media type the spec lists available types  [“image”, “audio”].  "video" is also being returned and supported
* result with nasa_id LRC-1962-B701_P-03646 has date_created of "0962-05-09T00:00:00Z"

