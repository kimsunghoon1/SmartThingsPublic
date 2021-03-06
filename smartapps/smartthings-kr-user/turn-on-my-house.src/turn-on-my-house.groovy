/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Big Turn ON
 *
 *  Author: SmartThings
 */

definition(
    name: "Turn ON My House",
    namespace: "smartthings_kr User",
    author: "kim sung hoon",
    description: "Turn your lights on when the SmartApp is tapped or activated.",
    category: "Convenience",
    iconUrl: "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSKXM50XzBI4OLfxC8PBmMQ1jQKvM0bObhKEs95bQAahGnMNU5BGA",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Meta/light_outlet@2x.png"
)

preferences {
	section("When I touch the app, turn on...") {
		input "switches", "capability.switch", multiple: true
	}
}

def installed()
{
	subscribe(location, changedLocationMode)
	subscribe(app, appTouch)
}

def updated()
{
	unsubscribe()
	subscribe(location, changedLocationMode)
	subscribe(app, appTouch)
}

def changedLocationMode(evt) {
	log.debug "changedLocationMode: $evt"
	switches?.on()
}

def appTouch(evt) {
	log.debug "appTouch: $evt"
	switches?.on()
}