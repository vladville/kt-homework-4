
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun TestAdd() {
        val service = WallService
        //val comment = Comments(10, 2, 0, "First Comment")
        val result = service.add(Post(5, 1, "Vladimir", 0, "First post", null, 5, 5, true, 5, null))

        assertEquals(1, result.id)
    }

    @Test
    fun updateExistingTrue() {
        val service = WallService
        val comment = Comments(10, 2, 0, "First Comment")
        // заполняем несколькими постами
        service.add(Post(5, 1, "Vladimir", 0, "First post", comment, 5, 5, true, 5, null))
        service.add(Post(15, 1, "Vladimir", 0, "Second post", null, 5, 5, true, 15, null))
        service.add(Post(25, 1, "Vladimir", 0, "Third post", comment, 5, 5, true, 25, null))

        // создаём информацию об обновлении
        val update = Post(3, 1, "Vladimir", 0, "Third post", comment, 5, 5, true, 35, null)

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateExistingFalse() {
        val service = WallService
        val comment = Comments(10, 2, 0, "First Comment")
        // заполняем несколькими постами
        service.add(Post(5, 1, "Vladimir", 0, "First post", comment, 5, 5, true, 5))
        service.add(Post(15, 1, "Vladimir", 0, "Second post", comment, 5, 5, true, 15))
        service.add(Post(25, 1, "Vladimir", 0, "Third post", comment, 5, 5, true, 25))
        // создаём информацию об обновлении
        val update = Post(45, 1, "Vladimir", 0, "Third post", comment, 5, 5, true, 25)

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }
}