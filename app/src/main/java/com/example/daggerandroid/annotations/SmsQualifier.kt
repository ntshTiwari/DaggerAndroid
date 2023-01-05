package com.example.daggerandroid.annotations

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

/// we can define our own annotations in kotlin, to remove any change of types
/// this is an annotation that we will use in place of our @Named annotations

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class SmsQualifier()
