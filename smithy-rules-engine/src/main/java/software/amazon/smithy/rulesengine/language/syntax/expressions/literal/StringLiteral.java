/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package software.amazon.smithy.rulesengine.language.syntax.expressions.literal;

import java.util.Objects;
import java.util.Optional;
import software.amazon.smithy.model.FromSourceLocation;
import software.amazon.smithy.model.node.Node;
import software.amazon.smithy.rulesengine.language.syntax.expressions.Template;

public final class StringLiteral extends Literal {
    private final Template value;

    StringLiteral(Template value, FromSourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    public Template value() {
        return value;
    }

    @Override
    public <T> T accept(LiteralVisitor<T> visitor) {
        return visitor.visitString(value);
    }

    @Override
    public Optional<Template> asStringLiteral() {
        return Optional.of(value);
    }

    /**
     * Attempts to convert the literal to a {@link String}. Otherwise throws an exception.
     *
     * @return the literal as a string.
     */
    public String expectLiteralString() {
        return value.expectLiteral();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        StringLiteral that = (StringLiteral) obj;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Node toNode() {
        return value.toNode();
    }
}
