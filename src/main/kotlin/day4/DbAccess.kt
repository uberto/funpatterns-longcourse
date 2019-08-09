package day4

import day3.*

interface DbAccess {

    fun OrderId.read(): Outcome<DbError, Order>

    fun UserId.read(): Outcome<DbError, User>

    fun Order.write(): Outcome<DbError, OrderId>

    fun User.write(): Outcome<DbError, UserId>

}