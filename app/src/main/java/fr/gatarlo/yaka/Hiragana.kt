package fr.gatarlo.yaka

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Hiragana() : RealmObject(){
    var A_Hiragana:String = ""
    var I_Hiragana:String = ""
    var U_Hiragana:String = ""
    var E_Hiragana:String = ""
    var O_Hiragana:String = ""

}