data class Post(
    val id: Int,
    val authorId: Int,
    val authorName: String,
    val date: Int,
    val text: String,
    val comments: Comments,
    val likes: Int = 0,
    val views: Int,
    val canEdit: Boolean,
    val reposts: Int = 0
)

class Comments(var count: Int, var authorId: Int, var date: Int, var text: String)

object WallService {
    private var posts = emptyArray<Post>()
    private var lastPostId = 1


    fun add(post: Post): Post {
        posts += post.copy(id = lastPostId)
        lastPostId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postEl) in posts.withIndex()) {
            if (post.id == postEl.id)
                posts[index] = post
            return true
        }
        return false
    }
}

fun main() {
    val comment = Comments(10, 2, 0, "First Comment")
    val postOne = Post(5, 1, "Vladimir", 0, "First post", comment, 5, 5, true, 5)
    val postTwo = postOne.copy(id = 10, text = "Second post", likes = postOne.likes + 1)

    //show default data
    println(postOne)
    println(postTwo)

    //try to add
    println(WallService.add(postOne))
    val postForEdit = WallService.add(postTwo)

    //try to update
    println(WallService.update(postForEdit.copy(likes = postForEdit.likes + 5)))

    //show result
    println(postForEdit)


}