<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="text"/>

    <xsl:template match="/">id, author, title, genre, price, publishDate, description
        <xsl:for-each select="/catalog/book">
            <xsl:value-of select="concat(id,',',author,',',title,',',genre,',',price,',',publish_date,',',description,',','&#xA;')"/>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>