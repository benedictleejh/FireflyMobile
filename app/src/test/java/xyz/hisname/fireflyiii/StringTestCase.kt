package xyz.hisname.fireflyiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import xyz.hisname.fireflyiii.util.extension.isAscii

class StringTestCase {

    private val invalidBearerToken by lazy { "Bearer \uFEFFeyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImRlOGU3YzIzNjhkYTJkNTEwNTQzOWI5MzhkODhjOTFkMmY1MGRlZDhlNTgwMWFkMzMyMjJlNmFkYjIxYWU0OTRkYzUyOGY3MDJjYTQwNzU3In0.eyJhdWQiOiIxIiwianRpIjoiZGU4ZTdjMjM2OGRhMmQ1MTA1NDM5YjkzOGQ4OGM5MWQyZjUwZGVkOGU1ODAxYWQzMzIyMmU2YWRiMjFhZTQ5NGRjNTI4ZjcwMmNhNDA3NTciLCJpYXQiOjE1NTUxNzA2NjcsIm5iZiI6MTU1NTE3MDY2NywiZXhwIjoxNTg2NzkzMDY3LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.ZDVDJBYo5utRIaDDKqNHN6KYSinpHQAp-8LbUl0SJrf54W3JOL1kJafLBDy_Psx66vwqw1wUHnspUIPSgTnUD9_jyfGonVuf45lZ_Z2O7HF_amwYE27eDtMZKxis48cFhcJOMBjMYO2jRwkaZPhQSTyIM7DdeKBWTftykkm9nhF0-BylFCf2vMqLJgOekOLLOjlgp8-a4HBgQCjfz9nmcMxnwRv_AYu1-TSNqFwYBkH1yfK9JkkrLirgOijbgj6sOE0Ut98iTvE-ORWhmgAVoNjA7CarXGXQfI6lbBOZ8-bncpCO78XKCEljXirJ7dHG6vvFSQVYTqKEctkp8w9YO8Z-u7dmPWZx7KBV26Q092q70x6rA4wfoRTEkAWUC052NsCPWv3YdWqOIk4Df5S8XjrfiCkxjBR-9U-PU8BSLl3xtIjcf34JUzU-_DpGQx__Wlc1ibwgJInmI-XhGbDCryqJG5vNSZCY9Axlnn5MLpQbGMiJYf_qxTskv0uO0lOYmrKJXsu7gIn7uYX25axAnciYSxYomiWn1jbPHJcQ_KdUvrgqpGJAopbQHepSSXjBBSuo_nDzupmRaud6H4HXrJjRU1yS8qpAFc8FaibBwqNyZTVEI0dFDDxlYqStheYiy_AFeNGzpYo4zOrMalgiDpLT5JzP7Ut4AXGc5crmCz4" }
    private val validBearerToken by lazy { "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImRlOGU3YzIzNjhkYTJkNTEwNTQzOWI5MzhkODhjOTFkMmY1MGRlZDhlNTgwMWFkMzMyMjJlNmFkYjIxYWU0OTRkYzUyOGY3MDJjYTQwNzU3In0.eyJhdWQiOiIxIiwianRpIjoiZGU4ZTdjMjM2OGRhMmQ1MTA1NDM5YjkzOGQ4OGM5MWQyZjUwZGVkOGU1ODAxYWQzMzIyMmU2YWRiMjFhZTQ5NGRjNTI4ZjcwMmNhNDA3NTciLCJpYXQiOjE1NTUxNzA2NjcsIm5iZiI6MTU1NTE3MDY2NywiZXhwIjoxNTg2NzkzMDY3LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.ZDVDJBYo5utRIaDDKqNHN6KYSinpHQAp-8LbUl0SJrf54W3JOL1kJafLBDy_Psx66vwqw1wUHnspUIPSgTnUD9_jyfGonVuf45lZ_Z2O7HF_amwYE27eDtMZKxis48cFhcJOMBjMYO2jRwkaZPhQSTyIM7DdeKBWTftykkm9nhF0-BylFCf2vMqLJgOekOLLOjlgp8-a4HBgQCjfz9nmcMxnwRv_AYu1-TSNqFwYBkH1yfK9JkkrLirgOijbgj6sOE0Ut98iTvE-ORWhmgAVoNjA7CarXGXQfI6lbBOZ8-bncpCO78XKCEljXirJ7dHG6vvFSQVYTqKEctkp8w9YO8Z-u7dmPWZx7KBV26Q092q70x6rA4wfoRTEkAWUC052NsCPWv3YdWqOIk4Df5S8XjrfiCkxjBR-9U-PU8BSLl3xtIjcf34JUzU-_DpGQx__Wlc1ibwgJInmI-XhGbDCryqJG5vNSZCY9Axlnn5MLpQbGMiJYf_qxTskv0uO0lOYmrKJXsu7gIn7uYX25axAnciYSxYomiWn1jbPHJcQ_KdUvrgqpGJAopbQHepSSXjBBSuo_nDzupmRaud6H4HXrJjRU1yS8qpAFc8FaibBwqNyZTVEI0dFDDxlYqStheYiy_AFeNGzpYo4zOrMalgiDpLT5JzP7Ut4AXGc5crmCz4" }


    @Test
    fun isNonAscii(){
       assertEquals(false, invalidBearerToken.isAscii())
    }

    @Test
    fun isAscii(){
        assertEquals(true, validBearerToken.isAscii())
    }
}