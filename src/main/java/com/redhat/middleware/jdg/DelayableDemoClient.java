/*
* JBoss, Home of Professional Open Source
* Copyright 2011 Red Hat Inc. and/or its affiliates and other
* contributors as indicated by the @author tags. All rights reserved.
* See the copyright.txt in the distribution for a full listing of
* individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/

package com.redhat.middleware.jdg;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

/**
 * Provides a method to delay execution.
 * 
 * @author <a href="mailto:rtsang@redhat.com">Ray Tsang</a>
 *
 * @param <K>
 * @param <V>
 */
public abstract class DelayableDemoClient<K, V> extends AbstractHotRodDemoClient<K, V> {
	private static final long DEFAULT_DELAY_MS = 50;
	private long delayMs = DEFAULT_DELAY_MS;
	
	public DelayableDemoClient(RemoteCache<K,V> cache) {
		super(cache);
	}

	public DelayableDemoClient(RemoteCacheManager cm, String cacheName) {
		super(cm, cacheName);
	}
	

	protected void delay() {
		if (delayMs > 0) {
			try {
				Thread.sleep(delayMs);
			} catch (InterruptedException e) {
			}
		}
	}

	public long getDelayMs() {
		return delayMs;
	}

	public void setDelayMs(long delayMs) {
		this.delayMs = delayMs;
	}


}
