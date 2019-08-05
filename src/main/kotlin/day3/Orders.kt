package day3

data class DbError(override val msg: String) : Error

data class Order(val id: OrderId, val userId: UserId, val amount: Double)

data class User(val id: UserId, val name: String)

data class OrderId(val id: Int)

data class UserId(val id: Int)


