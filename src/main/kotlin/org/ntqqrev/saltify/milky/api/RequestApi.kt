package org.ntqqrev.saltify.milky.api

import org.ntqqrev.saltify.composeidl.Category
import org.ntqqrev.saltify.composeidl.StringType

val RequestApi = Category("request") {
    describe("请求 API")

    api("accept_request") {
        describe("同意请求")
        input {
            field("request_id", StringType, "请求 ID")
        }
    }

    api("reject_request") {
        describe("拒绝请求")
        input {
            field("request_id", StringType, "请求 ID")
            field("reason", StringType, "拒绝理由") { optional() }
        }
    }
}