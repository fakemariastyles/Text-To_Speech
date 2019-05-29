package com.mmb.texttospeech.local.service

import android.os.Binder

public class FileServiceBinder:Binder(){
    fun getService():FileService{
        return FileService()
    }
}