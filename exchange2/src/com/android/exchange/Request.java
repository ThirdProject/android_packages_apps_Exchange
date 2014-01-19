/*
 * Copyright (C) 2010 The Android Open Source Project
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

package com.android.exchange;

/**
 * Requests for mailbox actions are handled by subclasses of this abstract class.
 * Four subclasses are now defined: PartRequest (attachment load), MeetingResponseRequest
 * (respond to a meeting invitation), MessageMoveRequest (move a message to another folder)
 * and FetchMessageRequest (get the entire message)
 */
public abstract class Request {
    public final long mTimeStamp = System.currentTimeMillis();
    public final long mMessageId;

    public Request(long messageId) {
        mMessageId = messageId;
    }

    // Subclasses of Request may have different semantics regarding equality; therefore,
    // we force them to implement the equals method
    public abstract boolean equals(Object o);
    public abstract int hashCode();
}