package com.cheky.springboot.demo.xml;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import static org.custommonkey.xmlunit.XMLAssert.assertXpathExists;

/**
 * @author cheky
 * @date 2020-12-21
 */
public class XmlUnitTest {

    @Test
    public void testCompareDiffBetweenXml() throws IOException, SAXException {

        String expected = "<root></root>";
        String target = "<people></people>";
        Diff myDiff = XMLUnit.compareXML(expected, target);
        Assert.assertFalse("XML similar " + myDiff.toString(), myDiff.similar());
        Assert.assertFalse("XML identical " + myDiff.toString(), myDiff.identical());
        System.out.println(myDiff.toString());

        DetailedDiff detailedDiff = new DetailedDiff(new Diff(expected, target));
        List allDiffereneces = detailedDiff.getAllDifferences();
        System.out.println(allDiffereneces.toString());
    }

    @Test
    public void testSameXmlWithDiffComment() throws IOException, SAXException {
        XMLUnit.setIgnoreComments(true);
        String xml1 = "<root>BOOK</root>";
        String xml2 = "<root>BOOK<!--This is comment--></root><!--Comment-->";
        Diff myDiff = XMLUnit.compareXML(xml1, xml2);
        assert myDiff.identical();
    }

    @Test
    public void testSameXmlWithDiffWhitespace() throws IOException, SAXException {
        XMLUnit.setIgnoreWhitespace(true);
        String xml1 = "<root>BOOK</root>";
        String xml2 = "<root> BOOK </root>";
        Diff myDiff = XMLUnit.compareXML(xml1, xml2);
        assert myDiff.identical();
    }

    @Test
    public void testSameXmlWithDiffOrder() throws IOException, SAXException {
        XMLUnit.setIgnoreAttributeOrder(true);
        String xml1 = "<model name='tachyon-model' id='001'/>";
        String xml2 = "<model id='001' name='tachyon-model'/>";
        Diff myDiff = XMLUnit.compareXML(xml1, xml2);
        assert myDiff.identical();
    }

    @Test
    public void testXpath() throws SAXException, IOException, XpathException {
        String xmlFile = "<root><aberration-file id='009'>aberration.xml</aberration-file></root>";
        // Whether exist an 'aberration-file' element whose content is 'aberration.xl';
        assertXpathExists("//aberration-file['aberration.xml']", xmlFile);
        // Whether exist an 'aberration-file' element whose id is '009'
        assertXpathExists("//aberration-file[@id='009']", xmlFile);
    }
}
