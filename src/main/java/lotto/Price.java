package lotto;

import java.util.Objects;

public class Price {
    int price;

    public Price(int price) {
        validate(price);
        this.price = price;
    }

    public int value() {
        return this.price;
    }

    private void validate(int price) {
        validateMultipleOf1000(price);
        validateNotNegative(price);
    }

    private static void validateNotNegative(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("투입금액은 0원 이상이어야 합니다.");
        }
    }

    private static void validateMultipleOf1000(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("투입금액은 1000원 단위 이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
