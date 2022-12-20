package com.jfb.msclientes.utils

import org.slf4j.LoggerFactory

inline fun <reified T> logger(): org.slf4j.Logger {
  return LoggerFactory.getLogger(T::class.java)
}