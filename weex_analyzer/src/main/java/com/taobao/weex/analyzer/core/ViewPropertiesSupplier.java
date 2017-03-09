package com.taobao.weex.analyzer.core;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.taobao.weex.dom.ImmutableDomObject;
import com.taobao.weex.ui.component.WXComponent;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 *
 * Created by rowandjj(chuyi)<br/>
 */

public class ViewPropertiesSupplier {

    @NonNull
    public Map<String,String> supplyPropertiesFromVirtualView(@NonNull WXComponent component) {
        ImmutableDomObject domObject = component.getDomObject();
        if(domObject == null ) {
            return Collections.emptyMap();
        }
        Map<String,String> result = new LinkedHashMap<>();

        if(domObject.getStyles() != null) {
            for (Map.Entry<String, Object> entry : domObject.getStyles().entrySet()) {
                if (entry.getValue() != null) {
                    result.put(entry.getKey(), entry.getValue().toString());
                }
            }
        }

        if(domObject.getAttrs() != null) {
            for(Map.Entry<String,Object> entry : domObject.getAttrs().entrySet()) {
                if(entry.getValue() != null) {
                    result.put(entry.getKey(),entry.getValue().toString());
                }
            }
        }

        return Collections.unmodifiableMap(result);
    }

    @NonNull
    public Map<String,String> supplyPropertiesFromNativeView(@NonNull View view) {
        Map<String,String> result = new LinkedHashMap<>();
        result.put(BoxModelConstants.LEFT, String.valueOf(view.getLeft()));
        result.put(BoxModelConstants.TOP, String.valueOf(view.getTop()));
        result.put(BoxModelConstants.RIGHT, String.valueOf(view.getRight()));
        result.put(BoxModelConstants.BOTTOM, String.valueOf(view.getBottom()));

        result.put(BoxModelConstants.WIDTH, String.valueOf(view.getWidth()));
        result.put(BoxModelConstants.HEIGHT, String.valueOf(view.getHeight()));

        result.put(BoxModelConstants.PADDING_LEFT, String.valueOf(view.getPaddingLeft()));
        result.put(BoxModelConstants.PADDING_TOP, String.valueOf(view.getPaddingTop()));
        result.put(BoxModelConstants.PADDING_RIGHT, String.valueOf(view.getPaddingRight()));
        result.put(BoxModelConstants.PADDING_BOTTOM, String.valueOf(view.getPaddingBottom()));

        result.put(BoxModelConstants.VISIBILITY, (view.getVisibility() == View.VISIBLE ? "visible":"invisible"));

        ViewGroup.LayoutParams params = view.getLayoutParams();
        if(params != null && params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) params;
            result.put(BoxModelConstants.MARGIN_LEFT, String.valueOf(marginLayoutParams.leftMargin));
            result.put(BoxModelConstants.MARGIN_TOP, String.valueOf(marginLayoutParams.topMargin));
            result.put(BoxModelConstants.MARGIN_RIGHT, String.valueOf(marginLayoutParams.rightMargin));
            result.put(BoxModelConstants.MARGIN_BOTTOM, String.valueOf(marginLayoutParams.bottomMargin));
        }

        result.put(BoxModelConstants.BORDER_LEFT_WIDTH, null);
        result.put(BoxModelConstants.BORDER_RIGHT_WIDTH, null);
        result.put(BoxModelConstants.BORDER_TOP_WIDTH, null);
        result.put(BoxModelConstants.BORDER_BOTTOM_WIDTH, null);

        //todo background color
        //text color
        //text

        return Collections.unmodifiableMap(result);
    }


    public interface BoxModelConstants {
        String DEFAULT_WIDTH = "defaultWidth";
        String DEFAULT_HEIGHT = "defaultHeight";
        String HREF = "href";
        String WIDTH = "width";
        String MIN_WIDTH = "minWidth";
        String MAX_WIDTH = "maxWidth";
        String HEIGHT = "height";
        String MIN_HEIGHT = "minHeight";
        String MAX_HEIGHT = "maxHeight";
        String ALIGN_ITEMS = "alignItems";
        String ALIGN_SELF = "alignSelf";
        String FLEX = "flex";
        String FLEX_DIRECTION = "flexDirection";
        String JUSTIFY_CONTENT = "justifyContent";
        String FLEX_WRAP = "flexWrap";

        String MARGIN = "margin";
        String MARGIN_TOP = "marginTop";
        String MARGIN_LEFT = "marginLeft";
        String MARGIN_RIGHT = "marginRight";
        String MARGIN_BOTTOM = "marginBottom";
        String PADDING = "padding";
        String PADDING_TOP = "paddingTop";
        String PADDING_LEFT = "paddingLeft";
        String PADDING_RIGHT = "paddingRight";
        String PADDING_BOTTOM = "paddingBottom";

        String LEFT = "left";
        String TOP = "top";
        String RIGHT = "right";
        String BOTTOM = "bottom";

        String BACKGROUND_COLOR = "backgroundColor";
        String BACKGROUND_IMAGE = "backgroundImage";
        String OPACITY = "opacity";
        String BORDER_RADIUS = "borderRadius";
        String BORDER_WIDTH = "borderWidth";
        String BORDER_COLOR = "borderColor";
        String BORDER_STYLE = "borderStyle";
        String BORDER_TOP_WIDTH = "borderTopWidth";
        String BORDER_RIGHT_WIDTH = "borderRightWidth";
        String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
        String BORDER_LEFT_WIDTH = "borderLeftWidth";
        String BORDER_TOP_COLOR = "borderTopColor";
        String BORDER_RIGHT_COLOR = "borderRightColor";
        String BORDER_BOTTOM_COLOR = "borderBottomColor";
        String BORDER_LEFT_COLOR = "borderLeftColor";
        String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
        String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
        String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
        String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
        String BORDER_RIGHT_STYLE = "borderRightStyle";
        String BORDER_BOTTOM_STYLE = "borderBottomStyle";
        String BORDER_LEFT_STYLE = "borderLeftStyle";
        String BORDER_TOP_STYLE = "borderTopStyle";

        String POSITION = "position";

        String TEXT_DECORATION = "textDecoration";
        String TEXT_ALIGN = "textAlign";
        String FONT_WEIGHT = "fontWeight";
        String FONT_STYLE = "fontStyle";
        String FONT_SIZE = "fontSize";
        String COLOR = "color";
        String LINES = "lines";
        String FONT_FAMILY = "fontFamily";
        String TEXT_OVERFLOW = "textOverflow";
        String ELLIPSIS = "ellipsis";
        String LINE_HEIGHT = "lineHeight";
        String DISABLED = "disabled";
        String VALUE = "value";
        String IMAGE_QUALITY = "imageQuality";
        String FILTER = "filter";
        String QUALITY = "quality";
        String SRC = "src";
        String PLACE_HOLDER = "placeHolder";
        String RESIZE_MODE = "resizeMode";
        String SHOW_INDICATORS = "showIndicators";
        String AUTO_PLAY = "autoPlay";
        String SHOW_SCROLLBAR = "showScrollbar";
        String SCROLL_DIRECTION = "scrollDirection";
        String SCOPE = "scope";
        String LOADMORERETRY = "loadmoreretry";
        String LOADMOREOFFSET = "loadmoreoffset";
        String RECYCLE_IMAGE = "recycleImage";
        String OVERFLOW = "overflow";
        String TYPE = "type";
        String PLACEHOLDER = "placeholder";
        String PLACEHOLDER_COLOR = "placeholderColor";
        String AUTOFOCUS = "autofocus";
        String SINGLELINE = "singleline";
        String MAX_LENGTH = "maxLength";
        String MAXLENGTH = "maxlength";
        String ROWS = "rows";
        String CHECKED = "checked";
        String VISIBILITY = "visibility";
        String ITEM_COLOR = "itemColor";
        String ITEM_SELECTED_COLOR = "itemSelectedColor";
        String ITEM_SIZE = "itemSize";
        String DISPLAY = "display";
        String SHOW_LOADING = "show-loading";
        String SUFFIX = "suffix";
        String RESIZE = "resize";
        String IMAGE_SHARPEN = "imageSharpen";
        String SHARPEN = "sharpen";
        String PREFIX = "prefix";
        String INDEX = "index";
        String INTERVAL = "interval";
        String PLAY_STATUS = "playStatus";
        String FONT_FACE = "fontFace";
        String MAX = "max";
        String MIN = "min";
        String NAV_BAR_VISIBILITY = "hidden";
        String OFFSET_X_ACCURACY = "offsetXAccuracy";
        String OFFSET_X_RATIO = "offsetXRatio";
        String ELEVATION = "elevation";
        String SCROLLABLE = "scrollable";
        String DISTANCE_Y = "dy";
        String PULLING_DISTANCE = "pullingDistance";
        String VIEW_HEIGHT = "viewHeight";
        String PREVENT_MOVE_EVENT = "preventMoveEvent";
    }

}
