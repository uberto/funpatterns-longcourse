package day4

import day3.*

interface DbAccess {

    fun OrderId.read(): Outcome<DbError, Order>

    fun UserId.read(): Outcome<DbError, User>

    fun Order.update(): Outcome<DbError, Unit>

    fun User.update(): Outcome<DbError, Unit>

    fun Order.write(): Outcome<DbError, OrderId>

    fun User.write(): Outcome<DbError, UserId>

}