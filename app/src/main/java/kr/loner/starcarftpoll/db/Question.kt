package kr.loner.starcarftpoll.db

data class Question(
    var current: String,
    var paper: String,
    var option: List<String>,
    var answer: Int
)