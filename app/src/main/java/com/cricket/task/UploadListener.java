/*
 * Copyright (C) 2014 Fungroo
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.cricket.task;

import android.content.Context;


/**
 * @author Shailendra (shailendrarao17@gmail.com)
 */
public interface UploadListener {
    void uploadComplete(int statusCode,String resMsg, Context context,String status);
    //void progressUpdate(String currentFile, int progress, int total);
}
