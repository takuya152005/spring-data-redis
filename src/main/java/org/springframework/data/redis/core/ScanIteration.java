/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.redis.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@link ScanIteration} holds the values contained in Redis {@literal Multibulk reply} on exectuting {@literal SCAN}
 * command.
 * 
 * @author Christoph Strobl
 * @since 1.3
 */
public class ScanIteration<T> {

	private final long cursorId;
	private final List<T> items;

	/**
	 * @param cursorId
	 * @param items
	 */
	public ScanIteration(long cursorId, List<T> items) {

		this.cursorId = cursorId;
		this.items = (items != null ? new ArrayList<T>(items) : Collections.<T> emptyList());
	}

	/**
	 * The cursor id to be used for subsequent requests.
	 * 
	 * @return
	 */
	public long getCursorId() {
		return cursorId;
	}

	/**
	 * Get the items returned.
	 * 
	 * @return
	 */
	public List<T> getItems() {
		return items;
	}

}
