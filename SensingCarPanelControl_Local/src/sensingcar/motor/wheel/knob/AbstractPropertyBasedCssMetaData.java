/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensingcar.motor.wheel.knob;

import javafx.beans.property.Property;
import javafx.css.CssMetaData;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;

/**
 *
 * @author USER
 */
public abstract class AbstractPropertyBasedCssMetaData<S extends Styleable, V> extends CssMetaData<S, V> {

    private String propertyName;

    /**
     * Default Constructor
     *
     * @param property name of the CSS property
     * @param converter the StyleConverter used to convert the CSS parsed value
     * to a Java object.
     * @param propertyName Name of the property field
     * @param defaultValue The default value of the corresponding
     * StyleableProperty
     */
    public AbstractPropertyBasedCssMetaData(String property, StyleConverter<?, V> converter, String propertyName, V defaultValue) {
        super(property, converter, defaultValue);
        this.propertyName = propertyName;
    }

    protected abstract <T extends Property<V> & StyleableProperty<V>> T getProperty(S styleable);

    /**
     * Returns the field name of the property
     *
     * @return name of the property
     */
    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public boolean isSettable(S styleable) {
        Property<V> property = getProperty(styleable);
        return property == null || !property.isBound();
    }

    @Override
    public StyleableProperty<V> getStyleableProperty(S styleable) {
        return (StyleableProperty<V>) getProperty(styleable);
    }

}
