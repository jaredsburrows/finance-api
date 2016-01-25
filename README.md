FinanceAPI -- BETA [![Build Status](https://travis-ci.org/jaredsburrows/finance-api.svg?branch=master)](https://travis-ci.org/jaredsburrows/finance-api) [![Coverage Status](https://coveralls.io/repos/github/jaredsburrows/finance-api/badge.svg?branch=master)](https://coveralls.io/github/jaredsburrows/finance-api?branch=master)
=================

Simple Finance API for viewing stock quotes

## Usage:

    buildscript {
    	repositories {
    		jcenter()
    	}
    }

    dependencies {
        compile 'burrows.api:finance-core:0.0.1'
    }

## Examples:

    // Create basic Request URL
    String requestUrl = Builders.request()
                    .withYahoo()                 // Set the Company API
                    .withProperty(Property.Name) // Set the Properties, (eg. Name of the company)
                    .outputJSON()                // Set the Format for the data returned
                    .getQuote("MSFT")            // Add a Quote
                    .buildURL();


## License:

    Copyright (C) 2015 Finance API by Jared Burrows

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
