package com.cousinsco.restik.core

enum class EnumRoles(var roleName : String ) {
    OWNER("Restoran sahibi"),
    WAITER("Garson"),
    CHEF("Şef"),
    ACCOUNTING("Muhasebe")

}
fun Array<EnumRoles>.toStringList() : List<String>{
    val emptyList = mutableListOf<String>()
    EnumRoles.values().forEach {
        emptyList.add(it.roleName)
    }


    return emptyList
}