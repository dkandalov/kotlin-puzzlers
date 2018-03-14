import org.junit.Test

@Test fun ``() {}
@Test fun ` `() {}
@Test fun `everything works.`() {}
@Test fun `1/1/ is ok; 1/0 is an error`() {}

/*
A) ok; ok; ok; ok
B) error; ok; ok error
C) error; ok; error; error
D) error; error; error; error
*/