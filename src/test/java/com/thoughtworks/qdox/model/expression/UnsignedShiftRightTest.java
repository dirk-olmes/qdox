package com.thoughtworks.qdox.model.expression;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class UnsignedShiftRightTest
{

    @Test
    public void testParameterValue()
    {
        AnnotationValue lhs = mock( AnnotationValue.class );
        AnnotationValue rhs = mock( AnnotationValue.class );
        when( lhs.getParameterValue() ).thenReturn( "2" );
        when( rhs.getParameterValue() ).thenReturn( "3" );
        UnsignedShiftRight expr = new UnsignedShiftRight( lhs, rhs );
        assertEquals( "2 >>> 3", expr.getParameterValue() );
    }

    @Test
    public void testToString()
    {
        AnnotationValue lhs = mock( AnnotationValue.class );
        AnnotationValue rhs = mock( AnnotationValue.class );
        UnsignedShiftRight expr = new UnsignedShiftRight( lhs, rhs );
        assertEquals( lhs + " >>> " + rhs, expr.toString() );
    }
    
    @Test
    public void testAccept()
    {
        AnnotationVisitor visitor = mock( AnnotationVisitor.class );
        UnsignedShiftRight expr = new UnsignedShiftRight( null, null );
        Object visitResult = new Object();
        when( visitor.visit( expr ) ).thenReturn( visitResult );
        assertSame( expr.accept( visitor ), visitResult );
    }
}