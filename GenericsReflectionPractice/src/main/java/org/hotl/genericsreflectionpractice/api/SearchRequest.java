package org.hotl.genericsreflectionpractice.api;

public record SearchRequest(
        String massiveText,
        String itemText
) {
}
