<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns="http://www.w3.org/1999/XSL/Format" 
	xmlns:svg="http://www.w3.org/2000/svg" 
	xmlns:func="http://exslt.org/functions" 
	xmlns:math="http://exslt.org/math" version="2.0">
	
	<xsl:template match="document">
		<root font-size="10pt" font-family="sans-serif">
			<layout-master-set>
				<simple-page-master master-name="Page1" margin-right="14.4mm" margin-left="25mm" margin-top="18mm" page-width="210mm" page-height="297mm">
					<region-body margin-top="33mm" margin-bottom="20mm"/>
					<region-before extent="30mm"/>
					<region-after margin-left="25mm" margin-right="14.4mm" extent="20mm"/>
				</simple-page-master>
			</layout-master-set>
			<page-sequence master-reference="Page1" id="{generate-id(.)}" initial-page-number="1">
				<xsl:call-template name="Header"/>
				<xsl:call-template name="Footer"/>
				<flow flow-name="xsl-region-body">
					<block-container page-break-after="always">
						<xsl:call-template name="Seller"/>
						<xsl:call-template name="Customer"/>
						<xsl:call-template name="Vehicle"/>
					</block-container>
				</flow>
		</page-sequence>
		</root>
	</xsl:template>
	
	<!-- Seller Info -->
	<xsl:template name="Seller">
		<block-container space-before="8mm" space-after="5mm">
					<block font-weight="bold">Verkäufer</block>
					<table>
						<table-column column-width="50mm"/>
						<table-column column-width="100mm"/>
						<table-body>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Vorname:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="seller/firstName"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Familienname:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="seller/lastName"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Straße, Hausnummer:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center">
										<inline padding-right="2mm">
											<xsl:value-of select="seller/streetName"/>
										</inline>
										<xsl:value-of select="seller/streetNumber"/>
									</block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>PLZ:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="seller/zip"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Ort:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="seller/city"/></block>
								</table-cell>
							</table-row>
						</table-body>
					</table>
				</block-container>
	</xsl:template>
	
	<!-- customer Info -->
	<xsl:template name="Customer">
		<block-container space-after="5mm">
					<block font-weight="bold">Käufer</block>
					<table>
						<table-column column-width="50mm"/>
						<table-column column-width="100mm"/>
						<table-body>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Vorname:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="customer/firstName"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Familienname:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="customer/lastName"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Straße, Hausnummer:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center">
										<inline padding-right="2mm">
											<xsl:value-of select="customer/streetName"/>
										</inline>
										<xsl:value-of select="customer/streetNumber"/>
									</block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>PLZ:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="customer/zip"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Ort:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="customer/city"/></block>
								</table-cell>
							</table-row>
						</table-body>
					</table>
				</block-container>
	</xsl:template>
	
	<!-- vehicle Info -->
	<xsl:template name="Vehicle">
		<block-container space-after="2mm">
					<block font-weight="bold">Fahrzeugdaten</block>
					<table>
						<table-column column-width="50mm"/>
						<table-column column-width="100mm"/>
						<table-body>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Marke:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="vehicle/brand"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Type:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="vehicle/vehicleType"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Baujahr:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="vehicle/manufactureYear"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Modell:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="vehicle/modelName"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Fahrgestellnummer:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="vehicle/chassisNumber"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Motornummer:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="vehicle/motorNumber"/></block>
								</table-cell>
							</table-row>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Kilometerstand:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="vehicle/mileage"/></block>
								</table-cell>
							</table-row>
						</table-body>
					</table>
				</block-container>
				<block-container padding="1mm">
					<block>Sonstige Angaben:</block>
				</block-container>
				<block-container width="150mm" height="40mm" border="1pt solid #000000" background-color="lavender">
					<block> </block>
				</block-container>
				<block-container space-before="5mm" padding="1mm">
					<block font-weight="bold">Kaufpreis:</block>
					<table>
						<table-column column-width="50mm"/>
						<table-column column-width="25mm"/>
						<table-body>
							<table-row>
								<table-cell padding="1mm" column-number="1">
									<block>Der Kaufpreis beträgt in Euro:</block>
								</table-cell>
								<table-cell padding="1mm" background-color="#E6E6FA" border="1pt solid #000000" column-number="2">
									<block text-align="center"><xsl:value-of select="vehicle/price"/></block>
								</table-cell>
							</table-row>
						</table-body>
					</table>
				</block-container>
				<table space-before="15mm" width="100%" display-align="center">
					<table-column column-width="105mm"/>
					<table-column column-width="45mm"/>
					<table-body>
						<table-row>
							<table-cell>
								<block-container width="45mm" space-before="15mm" padding="1mm" display-align="center">
									<block font-size="8pt" border-top="solid 2pt #F38222">
										Unterschrift des Verkäufers
									</block>
								</block-container>
							</table-cell>
							<table-cell>
								<block-container width="45mm" space-before="15mm" padding="1mm" display-align="center">
									<block font-size="8pt" border-top="solid 2pt #F38222">
										Unterschrift des Käufers
									</block>
								</block-container>
							</table-cell>
						</table-row>
					</table-body>
				</table>
				
				
	</xsl:template>
	
	
	
	<!-- Header -->
	<xsl:template name="Header">
		<static-content flow-name="xsl-region-before">
			<block-container position="fixed" left="25mm" top="20mm">
				<block font-size="25pt" font-weight="bold">Kfz-Kaufvertrag</block>
			</block-container>
			<block-container position="absolute" top="-12mm" right="-5mm">
				<block text-align="right">
					<external-graphic src="./car.png" content-width="25%" content-height="23%"/>
				</block>
			</block-container>
		</static-content>
	</xsl:template>
	<!-- Footer -->
	<xsl:template name="Footer">
		<static-content flow-name="xsl-region-after">
		<block-container font-size="12pt">
			<block font-weight="bold">
				<inline>
				<xsl:value-of select="City"/>,
				</inline>
				<xsl:value-of select="Date"/>
			</block>
		</block-container>
		<block-container font-size="10pt" position="fixed" margin-right="5mm" top="290mm">
			<block text-align="right">Seite <page-number/> von <page-number-citation-last ref-id="{generate-id(.)}"/></block>
		</block-container>
		</static-content>
	</xsl:template>
</xsl:stylesheet>