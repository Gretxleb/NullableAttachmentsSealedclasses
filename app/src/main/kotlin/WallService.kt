class WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 1

    fun add(post: Post): Post {
        val newPost = post.copy(id = nextId++)
        posts += newPost
        return newPost
    }

    fun update(newPost: Post): Boolean {
        val index = posts.indexOfFirst { it.id == newPost.id }

        if (index >= 0) {
            posts[index] = newPost.copy(id = posts[index].id)
            return true
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        nextId = 1
    }
}
