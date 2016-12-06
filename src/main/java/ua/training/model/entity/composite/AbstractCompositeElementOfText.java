package ua.training.model.entity.composite;

import ua.training.model.entity.ElementOfText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Graffit on 06.12.2016.
 */
public abstract class AbstractCompositeElementOfText implements ElementOfText {
//    protected String currentCompositeText;
    protected List<ElementOfText> subElements = new ArrayList<>();

    @Override
    public abstract void parse(String text);

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ElementOfText element :
                subElements) {
            stringBuilder.append(element.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCompositeElementOfText)) return false;

        AbstractCompositeElementOfText that = (AbstractCompositeElementOfText) o;

        return subElements.equals(that.subElements);

    }

    @Override
    public int hashCode() {
        return subElements.hashCode();
    }
}
