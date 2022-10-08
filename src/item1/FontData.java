package item1;

import java.awt.*;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * @see <a href="https://ko.wikipedia.org/wiki/%ED%94%8C%EB%9D%BC%EC%9D%B4%EC%9B%A8%EC%9D%B4%ED%8A%B8_%ED%8C%A8%ED%84%B4">flyweight pattern - wekipdia<</a>
 * */

enum FontEffect {
    BOLD, ITALIC, SUPERSCRIPT, SUBSCRIPT, STRIKETHROUGH
}

public class FontData {
    private static final WeakHashMap<FontData, WeakReference<FontData>> flyweightData =
            new WeakHashMap<FontData, WeakReference<FontData>>();

    private final int pointSize;
    private final String fontFace;
    private final Color color;
    private final Set<FontEffect> effects;

    private FontData(int pointSize, String fontFace, Color color, EnumSet<FontEffect> effects){
        this.pointSize = pointSize;
        this.fontFace = fontFace;
        this.color = color;
        /* unmodifiableSet : readonly */
        this.effects = Collections.unmodifiableSet(effects);
    }

    public static FontData create(int pointSize, String fontFace, Color color, FontEffect... effects){
        EnumSet<FontEffect> effectsSet = EnumSet.noneOf(FontEffect.class);
        for (FontEffect fontEffect : effects) {
            effectsSet.add(fontEffect);
        }
        // 객체를 생성하는 데 드는 비용이나 객체가 차지하는 메모리 공간에 대해 걱정할 필요가 없다.
        FontData data = new FontData(pointSize, fontFace, color, effectsSet);
        if (!flyweightData.containsKey(data)) {
            flyweightData.put(data, new WeakReference(data));
        }

        return flyweightData.get(data).get();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FontData) {
            if (obj == this) {
                return true;
            }
            FontData other = (FontData) obj;
            return other.pointSize == pointSize && other.fontFace.equals(fontFace)
                    && other.color.equals(color) && other.effects.equals(effects);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (pointSize * 37 + effects.hashCode() * 13) * fontFace.hashCode();
    }

    // Getters for the font data, but no setters. FontData is immutable.

}
