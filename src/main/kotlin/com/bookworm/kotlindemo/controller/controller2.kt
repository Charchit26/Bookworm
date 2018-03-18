package com.bookworm.kotlindemo.controller


import org.json.simple.JSONArray
import java.io.FileReader
import java.io.IOException

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.json.simple.parser.ParseException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.web.bind.annotation.*
import java.io.File
import java.nio.file.Path

@RestController
class Controller2 {

    @Autowired
    lateinit var resourceLoader: ResourceLoader;


    internal var parser = JSONParser()


    @GetMapping("/")
    fun hello(): String{
        return "Hello"
    }

    @RequestMapping(value = "/getAllBooks")
    @Throws(IOException::class, ParseException::class)
    fun customerApi(): JSONArray{
        var companyFile:File = resourceLoader.getResource("classpath:/books.json").file
        val `object` = parser.parse(FileReader(companyFile))
        return `object` as JSONArray
    }

}