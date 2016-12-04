/*
 * Copyright 2016 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package flow.sample.orientation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import flowless.Flow;

public class OrientationSampleActivity
        extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orientation_activity_frame);
        OrientationSampleDispatcher.finishPendingTraversal();
    }

    @Override
    protected void attachBaseContext(Context baseContext) {
        baseContext = Flow.configure(baseContext, this) //
                .dispatcher(new OrientationSampleDispatcher(this)) //
                .defaultKey(LooseScreen.INSTANCE) //
                .install();
        super.attachBaseContext(baseContext);
    }

    @Override
    public void onBackPressed() {
        if(!Flow.get(this).goBack()) {
            super.onBackPressed();
        }
    }
}