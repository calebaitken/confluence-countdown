package ut.wiki.uqracing;

import org.junit.Test;
import wiki.uqracing.api.MyPluginComponent;
import wiki.uqracing.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}