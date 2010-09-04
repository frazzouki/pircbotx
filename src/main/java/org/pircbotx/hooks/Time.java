/**
 * Copyright (C) 2010 Leon Blakey <lord.quackstar at gmail.com>
 *
 * This file is part of PircBotX.
 *
 * PircBotX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PircBotX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PircBotX.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pircbotx.hooks;

import org.pircbotx.hooks.helpers.BaseEvent;
import org.pircbotx.hooks.helpers.BaseListener;
import org.pircbotx.hooks.helpers.BaseSimpleListener;

/**
 * This method is called whenever we receive a TIME request.
 *  <p>
 * This abstract implementation responds correctly, so if you override this
 * method, be sure to either mimic its functionality or to call
 * super.onTime(...);
 * @author Leon Blakey <lord.quackstar at gmail.com>
 */
public class Time {
	/**
	 * Simple listener that takes event parameters as parameters. See 
	 * {@link Time} for an explanation on use 
	 * @see Time 
	 */
	public static interface SimpleListener extends BaseSimpleListener {
		/**
		 * Simple Listener for Time Events. See {@link Time} for a complete description on when
		 * this is called.
		 * @see Time
		 * @see SimpleListener
		 */
		public void onTime(String sourceNick, String sourceLogin, String sourceHostname, String target);
	}

	/**
	 * Listener that receives an event. See {@link Time} for an explanation 
	 * on use and {@link Event} for an explanation on the event. 
	 * @see Time 
	 * @see Event 
	 */
	public static interface Listener extends BaseListener {
		/**
		 * Listener for Time Events. See {@link Time} for a complete description on when
		 * this is called.
		 * @see Time
		 * @see Listener
		 */
		public void onTime(Event event);
	}

	/**
	 * Event that is passed to all listeners that contains all the given
	 * information. See {@link Time} for an explanation on when this is created
	 * <p>
	 * <b>Note:<b> This class and all its subclasses are immutable since
	 * data should not change after creation
	 * @see Time 
	 * @see Listener
	 */
	public static class Event implements BaseEvent {
		protected final long timestamp;
		protected final String sourceNick;
		protected final String sourceLogin;
		protected final String sourceHostname;
		protected final String target;

		/**
		 * Default constructor to setup object. Timestamp is automatically set
		 * to current time as reported by {@link System#currentTimeMillis() }
		 * @param sourceNick The nick of the user that sent the TIME request.
		 * @param sourceLogin The login of the user that sent the TIME request.
		 * @param sourceHostname The hostname of the user that sent the TIME request.
		 * @param target The target of the TIME request, be it our nick or a channel name.
		 */
		public Event(String sourceNick, String sourceLogin, String sourceHostname, String target) {
			this.timestamp = System.currentTimeMillis();
			this.sourceNick = sourceNick;
			this.sourceLogin = sourceLogin;
			this.sourceHostname = sourceHostname;
			this.target = target;
		}

		public String getSourceHostname() {
			return sourceHostname;
		}

		public String getSourceLogin() {
			return sourceLogin;
		}

		public String getSourceNick() {
			return sourceNick;
		}

		public String getTarget() {
			return target;
		}

		public long getTimestamp() {
			return timestamp;
		}
	}
}
